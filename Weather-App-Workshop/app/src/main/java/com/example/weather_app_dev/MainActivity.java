package com.example.weather_app_dev;

import static android.widget.Toast.makeText;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.weather_app_dev.model.WeatherData;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.airbnb.lottie.LottieAnimationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView tvLocation, tvTemp, tvWindSpeed, tvHumidity, tvPressure, tvFeelsLike, tvCondition, tvDate;
    private EditText etSearchLocation;
    private Button btnSearch;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LottieAnimationView animationView , conditionAnimation;

    private FusedLocationProviderClient fusedLocationClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String API_KEY = "1395bcc1916947dea8e80728242411"; // Consider moving to BuildConfig

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        checkLocationPermission();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            checkLocationPermission();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void initializeViews() {
        tvLocation = findViewById(R.id.tv_location);
        tvTemp = findViewById(R.id.tv_temp);
        tvWindSpeed = findViewById(R.id.tv_wind_speed);
        tvHumidity = findViewById(R.id.tv_humidity);
        tvPressure = findViewById(R.id.tv_pressure);
        tvFeelsLike = findViewById(R.id.tv_feels_like);
        tvCondition = findViewById(R.id.tv_condition);
        tvDate = findViewById(R.id.tv_date);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        animationView = findViewById(R.id.animationView);
        conditionAnimation = findViewById(R.id.condition_animation);

        // Initialize search views
        etSearchLocation = findViewById(R.id.et_search_location);
        btnSearch = findViewById(R.id.btn_search);

        // Set up search functionality
        btnSearch.setOnClickListener(v -> performSearch());
        etSearchLocation.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch();
                return true;
            }
            return false;
        });

        updateDateTime();
    }

    private void updateDateTime() {
        String currentDate = new SimpleDateFormat("EEE, d MMMM", Locale.getDefault()).format(new Date());
        tvDate.setText("Last updated: " + currentDate);
    }
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            getCurrentLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                showError("Location permission is required for weather updates");
                // Fallback to default location
                fetchWeatherData("Dhaka");
            }
        }
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            fetchWeatherData(location.getLatitude() + "," + location.getLongitude());
                        } else {
                            fetchWeatherData("Dhaka"); // Fallback location
                        }
                    })
                    .addOnFailureListener(e -> {
                        showError("Could not get location");
                        fetchWeatherData("Dhaka"); // Fallback location
                    });
        }
    }

    private void fetchWeatherData(String location) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + location;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONObject current = response.getJSONObject("current");
                        JSONObject location_data = response.getJSONObject("location");

                        WeatherData currentWeather = new WeatherData();
                        currentWeather.tempC = current.getDouble("temp_c");
                        currentWeather.windKph = current.getDouble("wind_kph");
                        currentWeather.humidity = current.getDouble("humidity");
                        currentWeather.pressure = current.getDouble("pressure_mb");
                        currentWeather.feelslike = current.getDouble("feelslike_c");
                        currentWeather.condition = current.getJSONObject("condition").getString("text");
                        currentWeather.locationName = location_data.getString("name");
                        currentWeather.region = location_data.getString("region");

                        updateUI(currentWeather);
                        updateWeatherAnimation(currentWeather.condition);

                    } catch (JSONException e) {
                        showError("Error parsing weather data");
                    }
                }, error -> showError("Error loading weather data"));

        queue.add(jsonObjectRequest);
    }

    private void updateUI(WeatherData weather) {
        tvLocation.setText(weather.locationName + ", " + weather.region);
        tvTemp.setText(((int) weather.tempC) + "°C");
        tvWindSpeed.setText(weather.windKph + " km/h");
        tvHumidity.setText(weather.humidity + "%");
        tvPressure.setText(((int) weather.pressure) + " hPa");
        tvFeelsLike.setText("Feels like " + ((int) weather.feelslike) + "°C");
        tvCondition.setText(weather.condition);
        updateDateTime();
    }

    private void updateWeatherAnimation(String condition) {
        // Update animation based on weather condition
        condition = condition.toLowerCase();
        int mainAnimation = R.raw.moon;
        if (condition.contains("rain") || condition.contains("drizzle")) {
            animationView.setAnimation(R.raw.rain);
            mainAnimation = R.raw.rain;
        } else if (condition.contains("cloud")) {
            animationView.setAnimation(R.raw.cloud);
            mainAnimation = R.raw.cloud;
        } else if (condition.contains("sun") || condition.contains("clear")) {
            animationView.setAnimation(R.raw.sun);
            mainAnimation = R.raw.sun;
        } else {
            animationView.setAnimation(R.raw.moon); // default animation
        }
        animationView.setAnimation(mainAnimation);
        animationView.playAnimation();

        conditionAnimation.setAnimation(mainAnimation);
        conditionAnimation.playAnimation();
    }



    private void performSearch() {
        String location = etSearchLocation.getText().toString().trim();
        if (!location.isEmpty()) {
            // Hide keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etSearchLocation.getWindowToken(), 0);

            // Fetch weather for searched location
            fetchWeatherData(location);
        } else {
            showError("Please enter a location");
        }
    }

    private void showError(String message) {
        makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
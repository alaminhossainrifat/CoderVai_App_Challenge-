package com.example.weather_app_dev.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.example.weather_app_dev.R;
import com.example.weather_app_dev.model.ForecastData;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<ForecastData> forecasts;

    public ForecastAdapter(List<ForecastData> forecasts) {
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        ForecastData forecast = forecasts.get(position);
        holder.dateText.setText(forecast.date);
        holder.tempText.setText(((int) forecast.tempC) + "°C");
        holder.conditionText.setText(forecast.condition);
        updateWeatherAnimation(holder.animationView, forecast.condition);
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    private void updateWeatherAnimation(LottieAnimationView animationView, String condition) {
        condition = condition.toLowerCase();
        if (condition.contains("rain") || condition.contains("drizzle")) {
            animationView.setAnimation(R.raw.rain);
        } else if (condition.contains("cloud")) {
            animationView.setAnimation(R.raw.cloud);
        } else if (condition.contains("sun") || condition.contains("clear")) {
            animationView.setAnimation(R.raw.sun);
        } else {
            animationView.setAnimation(R.raw.moon);
        }
        animationView.playAnimation();
    }

    static class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView dateText, tempText, conditionText;
        LottieAnimationView animationView;

        ForecastViewHolder(View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.tv_forecast_date);
            tempText = itemView.findViewById(R.id.tv_forecast_temp);
            conditionText = itemView.findViewById(R.id.tv_forecast_condition);
            animationView = itemView.findViewById(R.id.forecast_animation);
        }
    }
}
package com.codervai.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codervai.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    NumberFormat numberFormat = new DecimalFormat("#.########");

    double storedValue = 0.0;
    String operator = "";
    String currentValue = "0";

    private boolean isScientificMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpListener();
    }

    private void setUpListener() {
        // Scientific mode toggle
        binding.scientificMode.setOnClickListener(v -> toggleScientificMode());
        binding.switchToBasic.setOnClickListener(v -> switchToBasicMode());

        // Basic calculator buttons
        List.of(
                binding.zero, binding.one, binding.two, binding.three,
                binding.four, binding.five, binding.six, binding.seven,
                binding.eight, binding.nine, binding.dot
        ).forEach(view -> view.setOnClickListener(this::digitClicked));

        List.of(
                binding.add, binding.subtract, binding.multiply, binding.divide
        ).forEach(view -> view.setOnClickListener(this::operationClicked));

        binding.equal.setOnClickListener(v -> {
            if (!currentValue.isEmpty() && !operator.isEmpty()) {
                storedValue = calculate();
                operator = "";
                currentValue = "";
                showScreen();
            }
        });

        binding.allClear.setOnClickListener(v -> {
            storedValue = 0.0;
            operator = "";
            currentValue = "0";
            showScreen();
        });

//        binding.clear.setOnClickListener(v -> {
//            currentValue = "0";
//            showScreen();
//        });

        binding.backspace.setOnClickListener(v -> {
            if (currentValue.length() > 0) {
                currentValue = currentValue.substring(0, currentValue.length() - 1); // Remove the last character
            }
            if (currentValue.isEmpty()) {
                currentValue = "0"; // If no characters are left, reset to "0"
            }
            showScreen();
        });

        // Scientific calculator buttons
        if (binding.scientificLayout != null) {
            List.of(
                    binding.sin, binding.cos, binding.tan
            ).forEach(button -> button.setOnClickListener(this::trigonometricFunction));

            binding.power.setOnClickListener(v -> {
                operator = "^";
                storedValue = Double.parseDouble(currentValue);
                currentValue = "0";
                showScreen();
            });

            binding.leftParenthesis.setOnClickListener(v -> handleParenthesis("("));
            binding.rightParenthesis.setOnClickListener(v -> handleParenthesis(")"));
        }
    }

    private void toggleScientificMode() {
        isScientificMode = true;
        binding.scientificLayout.setVisibility(View.VISIBLE);
        binding.switchToBasic.setVisibility(View.VISIBLE);
        binding.scientificMode.setVisibility(View.GONE);
        binding.buttonsLayout.setVisibility(View.VISIBLE); // Keep basic calculator visible
    }
    private void switchToBasicMode() {
        isScientificMode = false;
        binding.scientificLayout.setVisibility(View.GONE);
        binding.switchToBasic.setVisibility(View.GONE);
        binding.scientificMode.setVisibility(View.VISIBLE);
        binding.buttonsLayout.setVisibility(View.VISIBLE);
    }

    private void operationClicked(View view) {
        String operator = view.getTag().toString();
        if (this.operator.isEmpty()) {
            storedValue = Double.parseDouble(currentValue);
        } else {
            storedValue = calculate();
        }

        currentValue = "0";
        this.operator = operator;
        showScreen();
    }

    private double calculate() {
        double result = storedValue;
        double currentValue = Double.parseDouble(this.currentValue);

        switch (operator) {
            case "+":
                result += currentValue;
                break;
            case "-":
                result -= currentValue;
                break;
            case "*":
                result *= currentValue;
                break;
            case "/":
                result /= currentValue;
                break;
            case "^":
                result = Math.pow(result, currentValue);
                break;
        }

        return result;
    }

    private void digitClicked(View view) {
        String digit = view.getTag().toString();
        String currentText = currentValue + digit;
        currentValue = currentText.startsWith("0") && currentText.length() != 1 ?
                currentText.substring(1) : currentText;
        showScreen();
    }

    private void trigonometricFunction(View view) {
        try {
            double value = currentValue.isEmpty() ? storedValue : Double.parseDouble(currentValue);
            String function = view.getTag().toString();
            double result = 0;

            switch (function) {
                case "sin":
                    result = Math.sin(Math.toRadians(value));
                    break;
                case "cos":
                    result = Math.cos(Math.toRadians(value));
                    break;
                case "tan":
                    if (Math.abs(Math.cos(Math.toRadians(value))) < 1e-10) {
                        throw new ArithmeticException("Undefined result for tan(" + value + ")");
                    }
                    result = Math.tan(Math.toRadians(value));
                    break;
            }

            storedValue = result;
            currentValue = "";
            operator = "";
            showScreen();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            clearAll();
        } catch (ArithmeticException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            clearAll();
        }
    }

    private void handleParenthesis(String parenthesis) {
        if (currentValue.equals("0")) {
            currentValue = parenthesis;
        } else {
            currentValue += parenthesis;
        }
        showScreen();
    }

    private void showScreen() {
        binding.screen.setText(
                String.format("%s%s",
                        !operator.isEmpty() ?
                                (numberFormat.format(storedValue) + " " + operator + "\n") :
                                (storedValue != 0 ? String.format("%s\n", numberFormat.format(storedValue)) : ""),
                        currentValue)
        );
    }

    private void clearAll() {
        storedValue = 0.0;
        operator = "";
        currentValue = "0";
        showScreen();
    }
}
package com.example.weather_app_dev.model;

public class ForecastData {
    public String date;
    public double tempC;
    public String condition;
    public String conditionIcon;

    public ForecastData(String date, double tempC, String condition, String conditionIcon) {
        this.date = date;
        this.tempC = tempC;
        this.condition = condition;
        this.conditionIcon = conditionIcon;
    }
}
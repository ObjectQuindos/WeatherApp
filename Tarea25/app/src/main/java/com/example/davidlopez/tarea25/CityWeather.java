package com.example.davidlopez.tarea25;

import java.io.Serializable;

public class CityWeather implements Serializable {
    String cityName;
    Integer averageTemp;
    String generalWeather;
    String iconWeather;
    Integer max;
    Integer min;

    public CityWeather(String cityName) {
        this.cityName = cityName;
    }

    public CityWeather(String cityName, Integer averageTemp, String generalWeather, String iconWeather, Integer max, Integer min) {
        this.cityName = cityName;
        this.averageTemp = averageTemp;
        this.generalWeather = generalWeather;
        this.iconWeather = iconWeather;
        this.max = max;
        this.min = min;
    }
}
package com.example.davidlopez.tarea25;

import java.io.Serializable;

public class CityWeather implements Serializable {
    String cityName;
    Integer averageTemp;
    String generalWeather;
    String iconWeather;
    Integer min;
    Integer max;

    public CityWeather(String cityName) {
        this.cityName = cityName;
    }

    public CityWeather(String cityName, Integer averageTemp, String generalWeather, String iconWeather, Integer min, Integer max) {
        this.cityName = cityName;
        this.averageTemp = averageTemp;
        this.generalWeather = generalWeather;
        this.iconWeather = iconWeather;
        this.min = min;
        this.max = max;
    }
}
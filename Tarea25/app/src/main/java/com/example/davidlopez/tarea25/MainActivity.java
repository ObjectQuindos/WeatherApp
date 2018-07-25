package com.example.davidlopez.tarea25;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //dl.dropboxusercontent.com
    ListView listView;
    ArrayList<CityWeather> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WeatherApp");
        listView = (ListView) findViewById(R.id.listView);

        WeatherAPIRest weatherAPIRest = new WeatherAPIRest();
        weatherAPIRest.context = this;
        weatherAPIRest.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //createListOfCities();
    }

    public void setAdapter(ArrayList<CityWeather> citiesArray) {
        CitiesWeatherAdapter adapter = new CitiesWeatherAdapter(this, citiesArray);
        listView.setAdapter(adapter);
    }
}

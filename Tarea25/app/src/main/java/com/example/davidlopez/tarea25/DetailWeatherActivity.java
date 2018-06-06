package com.example.davidlopez.tarea25;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWeatherActivity extends AppCompatActivity {

    CityWeather cityWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);
        cityWeather = (CityWeather) getIntent().getSerializableExtra("cityWeather");
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView cityName = (TextView) findViewById(R.id.generalWeather);
        TextView minTemp = (TextView) findViewById(R.id.min);
        TextView maxTemp = (TextView) findViewById(R.id.max);
        ImageView weatherView = (ImageView) findViewById(R.id.weather);

        cityName.setText(cityWeather.generalWeather);
        minTemp.setText(cityWeather.min.toString());
        maxTemp.setText(cityWeather.max.toString());

        Resources resources = this.getResources();
        int resId = resources.getIdentifier(cityWeather.generalWeather.toLowerCase(), "drawable", this.getPackageName());
        weatherView.setImageResource(resId);
    }
}

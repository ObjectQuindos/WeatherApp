package com.example.davidlopez.tarea25;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class DetailWeatherActivity extends AppCompatActivity {

    CityWeather cityWeather;
    String imageCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);
        cityWeather = (CityWeather) getIntent().getSerializableExtra("cityWeather");
        imageCity = (String) getIntent().getSerializableExtra("imageCity");

        //getSupportActionBar();
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) tb.findViewById(R.id.toolbar_title);
        mTitle.setVisibility(View.GONE);
        //mTitle.setText("Holaaaa");
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(tb);
        //mTitle.setText(toolbar.getTitle());

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        setTitle(cityWeather.cityName);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView cityName = (TextView) findViewById(R.id.generalWeather);
        TextView minTemp = (TextView) findViewById(R.id.min);
        TextView maxTemp = (TextView) findViewById(R.id.max);
        ImageView weatherView = (ImageView) findViewById(R.id.weather);
        ImageView cityImage = (ImageView) findViewById(R.id.backcity);

        cityName.setText(cityWeather.averageTemp.toString() + "ºC");
        minTemp.setText(cityWeather.min.toString());
        maxTemp.setText(cityWeather.max.toString());

        Resources resources = this.getResources();
        int resId = resources.getIdentifier(cityWeather.generalWeather.toLowerCase(), "drawable", this.getPackageName());
        weatherView.setImageResource(resId);

        int resIdImageCity = resources.getIdentifier(imageCity, "drawable", this.getPackageName());
        cityImage.setImageResource(resIdImageCity);
    }
}

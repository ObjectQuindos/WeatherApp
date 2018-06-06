package com.example.davidlopez.tarea25;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CitiesWeatherAdapter extends ArrayAdapter<CityWeather> {

    Context context;
    ArrayList<CityWeather> citiesArray;

    public CitiesWeatherAdapter(Context context, ArrayList<CityWeather> cities) {
        super(context,0, cities);
        this.context = context;
        this.citiesArray = cities;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CityWeather city = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_item, parent, false);
        }

        TextView cityName = (TextView) convertView.findViewById(R.id.cityName);
        TextView temperature = (TextView) convertView.findViewById(R.id.temperature);
        ImageView weatherView = (ImageView) convertView.findViewById(R.id.weatherView);

        cityName.setText(city.cityName);
        temperature.setText(String.valueOf(city.averageTemp));

        Resources resources = getContext().getResources();
        int resId = resources.getIdentifier(city.generalWeather.toLowerCase(), "drawable", getContext().getPackageName());
        weatherView.setImageResource(resId);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailWeatherActivity.class);
                intent.putExtra("cityWeather", citiesArray.get(position));
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}

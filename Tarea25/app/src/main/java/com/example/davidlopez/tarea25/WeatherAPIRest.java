package com.example.davidlopez.tarea25;

import android.content.Context;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class WeatherAPIRest extends AsyncTask {

    ArrayList<CityWeather> cities;
    MainActivity context;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            getWeatherJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        updateUI();
    }

    private void updateUI() {
        context.setAdapter(cities);
    }

    private void getWeatherJson() throws IOException {
        cities = new ArrayList<CityWeather>();

        URL weatherEndPoint = new URL("https://dl.dropboxusercontent.com/s/jjcujt610ulogbn/weather.json?dl=0");
        HttpsURLConnection connection = (HttpsURLConnection) weatherEndPoint.openConnection();

        InputStream response = null;
        if (connection.getResponseCode() == 200) {
            response = connection.getInputStream();
            InputStreamReader responseReader = new InputStreamReader(response, "UTF-8");
            JsonReader jsonReader = new JsonReader(responseReader);
            jsonReader.beginObject();

            while (jsonReader.hasNext()) {
                String cityName = jsonReader.nextName();
                CityWeather cityWeather = readDataWeather(cityName, jsonReader);
                cities.add(cityWeather);
            }
        } else {
            Log.d("Connection", "HTTP conection failed");
        }
        connection.disconnect();
    }

    public CityWeather readDataWeather(String cityName, JsonReader reader) throws IOException {
        String generalWeather = null;
        Integer averageTemperature = null;
        Integer minTemp = null;
        Integer maxTemp = null;
        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("GeneralWeather")) {
                generalWeather = reader.nextString();
            } else if (name.equals("AverageTemperature")) {
                averageTemperature = reader.nextInt();
            } else if (name.equals("MinTemp")) {
                minTemp = reader.nextInt();
            } else if (name.equals("MaxTemp")) {
                maxTemp = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        CityWeather cityWeather = new CityWeather(cityName, averageTemperature, generalWeather, "clouds", minTemp, maxTemp);
        Log.d("myTag", cityWeather.cityName);
        return  cityWeather;
    }
}

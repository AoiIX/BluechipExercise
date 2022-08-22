package com.ews.bluechip.exercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ews.bluechip.exercise.fragment.CityFragment;
import com.ews.bluechip.exercise.fragment.WeatherDetailsFragment;
import com.ews.bluechip.exercise.weatherapi.model.WeatherResponseModel;
import com.ews.bluechip.exercise.weatherapi.retrofit.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    WeatherResponseModel weatherResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.weatherFragment, new CityFragment());
        ft.commit();
    }

    public void goToWeatherList(WeatherResponseModel weatherResponse){
        setWeatherResponse(weatherResponse);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.weatherFragment, new WeatherDetailsFragment());
        ft.commit();
    }

    public void setWeatherResponse(WeatherResponseModel weatherResponse){
        this.weatherResponse = weatherResponse;
    }

    public WeatherResponseModel getWeatherResponse(){
        return weatherResponse;
    }
}

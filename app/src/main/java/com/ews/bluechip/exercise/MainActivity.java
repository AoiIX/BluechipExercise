package com.ews.bluechip.exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ews.bluechip.exercise.fragment.CityFragment;
import com.ews.bluechip.exercise.fragment.WeatherDetailsFragment;
import com.ews.bluechip.exercise.fragment.WeatherListFragment;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    ListModel weatherResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.weatherFragment, new CityFragment());
        ft.commit();
    }

    public void goToWeatherList(ListModel weatherResponse){
        setWeatherResponse(weatherResponse);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.weatherFragment, new WeatherListFragment());
        ft.commit();
    }

    public void goToWeatherDetails(ListModel weatherResponseModel){
        WeatherDetailsFragment fragment = new WeatherDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", weatherResponseModel);
        fragment.setArguments(bundle);

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.weatherFragment, fragment);
        ft.commit();
    }

    public void setWeatherResponse(ListModel weatherResponse){
        this.weatherResponse = weatherResponse;
    }

    public ListModel getWeatherResponse(){
        return weatherResponse;
    }
}

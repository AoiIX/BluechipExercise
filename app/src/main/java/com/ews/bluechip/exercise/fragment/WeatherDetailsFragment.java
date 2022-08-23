package com.ews.bluechip.exercise.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;

public class WeatherDetailsFragment extends Fragment {
    private ListModel model;
    private TextView tvTemperature;
    private TextView tvRealFeel;
    private TextView tvWeather;
    private TextView tvWeatherDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_details, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        model = (ListModel) getArguments().getSerializable("model");

        tvTemperature = view.findViewById(R.id.tvTemperature);
        tvRealFeel = view.findViewById(R.id.tvRealFeel);
        tvWeather = view.findViewById(R.id.tvWeather);
        tvWeatherDesc = view.findViewById(R.id.tvWeatherDesc);

        tvTemperature.setText(String.valueOf(model.main.temp));
        tvRealFeel.setText(String.valueOf(model.cod));
        tvWeather.setText(model.weather.get(0).main);
        tvWeatherDesc.setText(model.weather.get(0).description);
    }
}

package com.ews.bluechip.exercise.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ews.bluechip.exercise.MainActivity;
import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.domain.CallbackResponse;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;
import com.ews.bluechip.exercise.weatherapi.retrofit.WeatherApiCall;

public class CityFragment extends Fragment {
    private EditText citiEditText;
    private Button button;
    private CallbackResponse responseCall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        responseCall = new CallbackResponse() {
            @Override
            public void callbackResponse(ListModel response) {
                goToMainActivity(response);
            }
        };
        citiEditText = view.findViewById(R.id.citiEditText);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfCityIsNull();
            }
        });
    }

    private void checkIfCityIsNull(){
        if (citiEditText.getText().toString().trim().equals("")){
            Toast.makeText(getContext(), "City cannot be empty = " + citiEditText.getText().toString(), Toast.LENGTH_SHORT).show();
        } else{
            WeatherApiCall weatherApiCall = new WeatherApiCall();
            weatherApiCall.getWeatherData(citiEditText.getText().toString(), responseCall);
        }
    }

    private void goToMainActivity(ListModel weatherResponse){
        ((MainActivity)getActivity()).goToWeatherList(weatherResponse);
    }
}

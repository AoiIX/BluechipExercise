package com.ews.bluechip.exercise.weatherapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.model.WeatherResponseModel;
import com.ews.bluechip.exercise.weatherapi.recycleview.RecycleAdapter;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<WeatherResponseModel> weatherList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        // Add the following lines to create RecyclerView
        RecycleAdapter adapter = new RecycleAdapter(weatherList);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
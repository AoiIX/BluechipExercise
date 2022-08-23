package com.ews.bluechip.exercise.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ews.bluechip.exercise.MainActivity;
import com.ews.bluechip.exercise.R;
import com.ews.bluechip.exercise.weatherapi.model.ListModel;
import com.ews.bluechip.exercise.weatherapi.recycleview.RecycleAdapter;

import java.util.ArrayList;


public class WeatherListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ListModel weatherResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_list, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weatherResponse = ((MainActivity) getActivity()).getWeatherResponse();
        recyclerView = view.findViewById(R.id.recyclerview);

        ArrayList<ListModel> weatherList = new ArrayList<>();
        weatherList.add(weatherResponse);
        weatherList.add(weatherResponse);
        weatherList.add(weatherResponse);
        RecycleAdapter adapter = new RecycleAdapter(weatherList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}

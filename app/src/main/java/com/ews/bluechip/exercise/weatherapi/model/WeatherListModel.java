package com.ews.bluechip.exercise.weatherapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherListModel {
    @SerializedName("list")
    public ArrayList<ListModel> listModels;
}

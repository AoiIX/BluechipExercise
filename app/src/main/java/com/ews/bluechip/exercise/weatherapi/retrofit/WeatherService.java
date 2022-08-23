package com.ews.bluechip.exercise.weatherapi.retrofit;

import com.ews.bluechip.exercise.weatherapi.model.ListModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/weather?")
    Call<ListModel> getCurrentWeatherData(@Query("q") String city, @Query("appid") String app_id);
}
package com.ews.bluechip.exercise.weatherapi.retrofit;

import androidx.annotation.NonNull;

import com.ews.bluechip.exercise.weatherapi.domain.CallbackResponse;
import com.ews.bluechip.exercise.weatherapi.model.WeatherResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiCall {
    WeatherResponseModel weatherResponse;
    private static final String BaseUrl = "http://api.openweathermap.org/";
    private static final String AppId = "65d00499677e59496ca2f318eb68c049";

    public void getWeatherData(String city, final CallbackResponse callbackResponse) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherResponseModel> call = service.getCurrentWeatherData(city, AppId);
        call.enqueue(new Callback<WeatherResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponseModel> call, @NonNull Response<WeatherResponseModel> response) {
                if (response.code() == 200) {
                    WeatherResponseModel weatherResponse = response.body();
                    assert weatherResponse != null;

                    callbackResponse.callbackResponse(weatherResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponseModel> call, @NonNull Throwable t) {
            }
        });
    }
}

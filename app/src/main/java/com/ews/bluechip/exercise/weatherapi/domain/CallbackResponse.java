package com.ews.bluechip.exercise.weatherapi.domain;

import com.ews.bluechip.exercise.weatherapi.model.WeatherResponseModel;

public interface CallbackResponse {
    void callbackResponse(WeatherResponseModel response);
}

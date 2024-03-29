package com.HninEiPhyu.WeatherApp.remote.retrofit;

import com.HninEiPhyu.WeatherApp.remote.dto.ResponseWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIService {
    @GET("/weather")
    Call<ResponseWeather> getCurrentWeatherData(@Header("x-rapidapi-key") String apiKey,
                                                @Query("units") String units,
                                                @Query("mode") String mode,
                                                @Query("q") String q);
}

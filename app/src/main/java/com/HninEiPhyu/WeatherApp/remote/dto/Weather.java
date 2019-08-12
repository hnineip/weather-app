package com.HninEiPhyu.WeatherApp.remote.dto;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    public String main;

    @SerializedName("description")
    public String description;

   public Weather(String main,
                  String description){

       this.main=main;
       this.description=description;
   }
}

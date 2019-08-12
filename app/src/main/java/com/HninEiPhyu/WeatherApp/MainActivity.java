package com.HninEiPhyu.WeatherApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.HninEiPhyu.WeatherApp.remote.dto.ResponseWeather;
import com.HninEiPhyu.WeatherApp.remote.retrofit.APIService;
import com.HninEiPhyu.WeatherApp.remote.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public TextView lblWeatherData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblWeatherData=findViewById(R.id.lblWeatherData);

        APIService service= RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
        Call<ResponseWeather> call=service.getCurrentWeatherData("51299292bcmsh5338338897a83d8p1a3afcjsn32798c7736d0",
                "\"metric\" or \"imperial\"",
                "xml,html",
                "Dawei,Myanmar");

        call.enqueue(new Callback<ResponseWeather>() {
            @Override
            public void onResponse(@NonNull Call<ResponseWeather> call, @NonNull Response<ResponseWeather> response) {
                if(response.isSuccessful()){
                    ResponseWeather responseWeather=response.body();
                    assert responseWeather !=null;

                    Log.d("MainActivity","weather main : "+responseWeather.weatherList.get(0).main);

                    Log.d("MainActivity","weather description : "+responseWeather.weatherList.get(0).description);

                    Log.d("MainActivity","main temp : "+responseWeather.main.temp);

                    Log.d("MainActivity","main temp_min : "+responseWeather.main.tempMin);

                    Log.d("MainActivity","main temp_max : "+responseWeather.main.tempMax);

                    lblWeatherData.setText("Weather main : " + responseWeather.weatherList.get(0).main+ "\n"
                            + "Weather description : "+ responseWeather.weatherList.get(0).description+"\n"
                            +"Temp : "+ responseWeather.main.temp + "\n"
                            +"Temp min: "+ responseWeather.main.tempMin + "\n"
                            +"Temp max: "+ responseWeather.main.tempMax + "\n");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseWeather> call, @NonNull Throwable t) {
                Log.d("MainActivity", String.format("Error: %s", t.getMessage()));
            }
        });
    }
}

package com.example.mvvmdemo.request
import com.example.mvvmdemo.entity.WeatherData
import retrofit2.Call
import retrofit2.http.GET

interface QueryWeatherRequest {

    @GET("data/cityinfo/101210101.html")
    fun queryWeather() : Call<WeatherData>

}
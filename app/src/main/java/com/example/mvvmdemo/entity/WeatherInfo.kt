package com.example.mvvmdemo.entity
import com.google.gson.annotations.SerializedName

class WeatherInfo(
    @SerializedName("city")
    var city: String,
    @SerializedName("cityid")
    var cityid: String,
    @SerializedName("temp1")
    var temp1: String,
    @SerializedName("temp2")
    var temp2: String,
    @SerializedName("weather")
    var weather: String,
    @SerializedName("img1")
    var img1: String,
    @SerializedName("img2")
    var img2: String,
    @SerializedName("ptime")
    var ptime: String
)
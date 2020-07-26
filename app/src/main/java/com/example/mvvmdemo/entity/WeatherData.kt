package com.example.mvvmdemo.entity

import com.google.gson.annotations.SerializedName

class WeatherData(@SerializedName("weatherinfo") var weatherinfo: WeatherInfo)
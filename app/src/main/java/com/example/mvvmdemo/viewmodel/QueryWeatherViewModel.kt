package com.example.mvvmdemo.viewmodel
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.mvvmdemo.request.QueryWeatherRequest
import com.example.mvvmdemo.entity.WeatherData
import com.example.mvvmdemo.http.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueryWeatherViewModel {

    val loading = ObservableBoolean(false)
    val loadingSuccess = ObservableBoolean(false)
    val loadingFailure = ObservableBoolean(false)

    val city = ObservableField<String>()
    val cityId = ObservableField<String>()
    val temp1 = ObservableField<String>()
    val temp2 = ObservableField<String>()
    val weather = ObservableField<String>()
    val time = ObservableField<String>()

    private var call: Call<WeatherData>? = null

    fun queryWeather() {

        loading.set(true)
        loadingSuccess.set(false)
        loadingFailure.set(false)

        call = RetrofitManager.retrofit.create(QueryWeatherRequest::class.java).queryWeather()
        call?.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {

                Log.d("onResponse","response.body():${response.body().toString()}")
                val weatherInfo = response.body()?.weatherinfo
                Log.d("onResponse","weatherInfo:${weatherInfo}")
                city.set(weatherInfo?.city)
                cityId.set(weatherInfo?.cityid)
                temp1.set(weatherInfo?.temp1)
                temp2.set(weatherInfo?.temp2)
                weather.set(weatherInfo?.weather)
                time.set(weatherInfo?.ptime)

                loading.set(false)
                loadingSuccess.set(true)
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                if (call.isCanceled) {
                    //
                } else {
                    loading.set(false)
                    loadingFailure.set(true)
                }
            }

        })
    }

    fun cancelRequest() {
        call?.cancel()
    }
}
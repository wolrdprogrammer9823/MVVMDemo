package com.example.mvvmdemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.mvvmdemo.databinding.ActivityWeatherBinding
import com.example.mvvmdemo.http.RetrofitManager
import com.example.mvvmdemo.http.TIME
import com.example.mvvmdemo.viewmodel.QueryWeatherViewModel
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class WeatherActivity : AppCompatActivity() {

    private val viewModel by lazy {
        QueryWeatherViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val weatherBinding: ActivityWeatherBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_weather)
        weatherBinding.viewModel = viewModel

//        val okHttpClient = OkHttpClient.Builder()
//            .connectTimeout(TIME, TimeUnit.SECONDS)
//            .readTimeout(TIME, TimeUnit.SECONDS)
//            .writeTimeout(TIME, TimeUnit.SECONDS)
//            .build()
//
//        val request = Request.Builder().url("http://www.weather.com.cn/data/cityinfo/101210101.html").build()
//        okHttpClient.newCall(request).enqueue(object : Callback{
//            override fun onFailure(call: Call, e: IOException) {
//
//                Log.d("request","override fun onFailure")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//
//                Log.d("request","override fun onResponse")
//                Log.d("request","result:${response.body?.string()}")
//            }
//        })

    }

    override fun onDestroy() {

        super.onDestroy()
        viewModel.cancelRequest()
    }
}
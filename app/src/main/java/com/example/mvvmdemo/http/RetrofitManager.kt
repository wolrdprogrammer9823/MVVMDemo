package com.example.mvvmdemo.http
import com.example.mvvmdemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "http://www.weather.com.cn/"
const val TIME = 10L

class RetrofitManager private constructor() {

   companion object {
       @JvmStatic
       private fun buildRetrofit() : Retrofit {

//           val httpLoggingInterceptor = HttpLoggingInterceptor()
//           httpLoggingInterceptor.level =
//               if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
//               else HttpLoggingInterceptor.Level.NONE
           val okHttpClient = OkHttpClient.Builder()
//               .addInterceptor(httpLoggingInterceptor)
               .connectTimeout(TIME,TimeUnit.SECONDS)
               .readTimeout(TIME,TimeUnit.SECONDS)
               .writeTimeout(TIME,TimeUnit.SECONDS)
               .build()
           return Retrofit.Builder()
               .baseUrl(BASE_URL).client(okHttpClient)
               .addConverterFactory(GsonConverterFactory.create()).build()
       }

       val retrofit = buildRetrofit()
   }

}
package com.s.siloamtestapp.network

import com.s.siloamtestapp.util.GlobalValue
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : ApiServices by lazy {
             Retrofit.Builder()
            .baseUrl(GlobalValue.baseValue)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}
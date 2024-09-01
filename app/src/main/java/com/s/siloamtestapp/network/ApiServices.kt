package com.s.siloamtestapp.network

import com.s.siloamtestapp.model.meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiServices {

    @GET("search.php")
    fun getRecipeData(
        @Query("f") f: String
    ): Call<meals>
}
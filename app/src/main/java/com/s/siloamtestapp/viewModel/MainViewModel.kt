package com.s.siloamtestapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.s.siloamtestapp.model.Data
import com.s.siloamtestapp.model.meals
import com.s.siloamtestapp.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    var recipeData = MutableLiveData<List<Data>>()


    //HIT API for get Recipe
    fun getDataRecipe(name: String) {

        RetrofitInstance.api.getRecipeData(name).enqueue(object :
            Callback<meals> {
            override fun onResponse(call: Call<meals>, response: Response<meals>) {
                if (response.body() != null) {
                    recipeData.value = response.body()!!.meals
                } else {
                    Log.d("TAGR",response.message())
                }
            }
            override fun onFailure(call: Call<meals>, t: Throwable) {
                Log.d("TAG Failure", t.message.toString())
            }
        })

    }

    fun getDataRecipeTesting(name: String) {

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRecipeData(name).execute()
                if (response.isSuccessful) {
                    recipeData.postValue(response.body()!!.meals)
                } else {
//                    _error.postValue("Error: ${response.message()}")
                }
            } catch (e: Exception) {
//                _error.postValue("Exception: ${e.message}")
            }

        }


    }






}
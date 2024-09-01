package com.s.siloamtestapp.Repository

import android.content.Context

class RepoImplementations(private val context: Context) : RepoInterfaces {


    private val sharedPreferenceRepo = SharedPreferenceRepo(context)
    lateinit var userData: ArrayList<String>
    override fun addData(user: String): Boolean {

        var prefData = sharedPreferenceRepo.getString()

        //name-password
        sharedPreferenceRepo.saveString("$prefData-$user")
        return true
    }

    override fun getData(): List<String> {
        userData = sharedPreferenceRepo.getString()?.split("-")?.map { it } as ArrayList<String>
        return userData

    }

    fun Contains (name:String):Boolean{

        return if (getData().contains(name)){
            false
        }else{
            true
        }


    }
}
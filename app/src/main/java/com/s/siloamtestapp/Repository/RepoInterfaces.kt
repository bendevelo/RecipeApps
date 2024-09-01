package com.s.siloamtestapp.Repository

interface RepoInterfaces {


    //Method for add data
    fun addData(user:String):Boolean

    //Method for get data
    fun getData():List<String>
}
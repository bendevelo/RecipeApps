package com.s.siloamtestapp.Repository

import android.content.Context

class SharedPreferenceRepo(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("SimpleDB", Context.MODE_PRIVATE)

    fun saveString( value: String) {
        val editor = sharedPreferences.edit()
        editor.putString("Dbz", value)
        editor.apply()
    }

    fun getString(): String? {
        return sharedPreferences.getString("Dbz", "")

    }
}
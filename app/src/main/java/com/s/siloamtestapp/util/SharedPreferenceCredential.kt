package com.s.siloamtestapp.util

import android.content.Context

class SharedPreferenceCredential(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("Credential", Context.MODE_PRIVATE)

    fun saveUsername( value: String) {
        val editor = sharedPreferences.edit()
        editor.putString("username", value)
        editor.apply()
    }

    fun getUsername(): String? {
        return sharedPreferences.getString("username", "")

    }

    fun savePassword( value: String) {
        val editor = sharedPreferences.edit()
        editor.putString("password", value)
        editor.apply()
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("password", "")

    }
}
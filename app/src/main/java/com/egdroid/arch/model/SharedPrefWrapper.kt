package com.egdroid.arch.model

import android.content.SharedPreferences

class SharedPrefWrapper(private val sharedPreferences: SharedPreferences) {

    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defValue: String = ""): String {
        return sharedPreferences.getString(key, defValue)!!
    }


}
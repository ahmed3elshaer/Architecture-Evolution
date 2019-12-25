package com.egdroid.arch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnswerAPI {
    @GET("/answer")
    fun getAnswer(): Call<Answer>
}
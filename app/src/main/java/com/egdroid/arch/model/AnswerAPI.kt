package com.egdroid.arch.model

import com.egdroid.arch.model.Answer
import retrofit2.Call
import retrofit2.http.GET

interface AnswerAPI {
    @GET("/answer")
    fun getAnswer(): Call<Answer>
}
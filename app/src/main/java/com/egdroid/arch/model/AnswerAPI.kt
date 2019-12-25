package com.egdroid.arch.model

import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import java.util.*

interface AnswerAPI {
    @GET("/answer")
    fun getAnswer(): Observable<Answer>
}
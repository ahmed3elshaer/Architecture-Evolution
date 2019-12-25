package com.egdroid.arch.main

import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswerAPI
import com.egdroid.arch.model.SharedPrefWrapper
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class AnswersRepository @Inject constructor(
    private val sharedPrefWrapper: SharedPrefWrapper,
    private val answerAPI: AnswerAPI
) {
    fun getRemoteAnswer(): Observable<Answer> = answerAPI.getAnswer()


    fun cacheAnswer(answer: Answer) =
        Completable.create { emitter ->
            sharedPrefWrapper.saveString(
                MainActivity.YES_KEY,
                answer.imageYes
            ).also { sharedPrefWrapper.saveString(MainActivity.NO_KEY, answer.imageNo) }
            emitter.onComplete()
        }


    fun checkCachedAnswer(): Observable<Answer> =
        if (sharedPrefWrapper.getString(MainActivity.YES_KEY).isEmpty() ||
            sharedPrefWrapper.getString(MainActivity.NO_KEY).isEmpty()
        )
            Observable.just(null)
        else
            Observable.just(
                Answer(
                    sharedPrefWrapper.getString(MainActivity.YES_KEY),
                    sharedPrefWrapper.getString(MainActivity.NO_KEY)
                )
            )


}
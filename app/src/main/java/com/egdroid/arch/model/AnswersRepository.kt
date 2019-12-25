package com.egdroid.arch.model

import com.egdroid.arch.main.MainActivity
import retrofit2.Response
import javax.inject.Inject

class AnswersRepository @Inject constructor(
    private val sharedPrefWrapper: SharedPrefWrapper,
    private val answerAPI: AnswerAPI
) {
    fun getRemoteAnswer(): Response<Answer> = answerAPI.getAnswer().execute()


    fun cacheAnswer(answer: Answer) =
        sharedPrefWrapper.saveString(
            MainActivity.YES_KEY,
            answer.imageYes
        ).also { sharedPrefWrapper.saveString(MainActivity.NO_KEY, answer.imageNo) }


    fun checkCachedAnswer(): Answer? =
        if (sharedPrefWrapper.getString(MainActivity.YES_KEY).isEmpty() ||
            sharedPrefWrapper.getString(MainActivity.NO_KEY).isEmpty()
        )
            null
        else
            Answer(
                sharedPrefWrapper.getString(MainActivity.YES_KEY),
                sharedPrefWrapper.getString(MainActivity.NO_KEY)
            )


}
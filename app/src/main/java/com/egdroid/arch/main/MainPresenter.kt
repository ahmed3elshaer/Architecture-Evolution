package com.egdroid.arch.main

import android.widget.Toast
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswersRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val answersRepository: AnswersRepository
) : MainContract.Presenter {


    override fun handleChoice(isYes: Boolean) {
        val cachedAnswer = answersRepository.checkCachedAnswer()
        if (cachedAnswer != null) {
            matchAnswers(isYes, cachedAnswer)
        } else {
            doAsync {
                val remoteAnswer = answersRepository.getRemoteAnswer().body()
                uiThread {
                    if (remoteAnswer == null)
                        view.showError("error getting answers")
                    else {
                        answersRepository.cacheAnswer(remoteAnswer)
                        matchAnswers(isYes, remoteAnswer)
                    }
                }
            }


        }
    }

    private fun matchAnswers(isYes: Boolean, answer: Answer) {
        if (isYes)
            view.renderAnswer(answer.imageYes)
        else
            view.renderAnswer(answer.imageNo)
    }


}
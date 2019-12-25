package com.egdroid.arch.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswersRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val answersRepository: AnswersRepository
) : ViewModel() {

    private val answerImageImpl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val answerImage: LiveData<String> = answerImageImpl

    private val errorImpl: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val error: LiveData<String> = errorImpl

    private val loadingImpl: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val loading: LiveData<Boolean> = loadingImpl

    fun handleChoice(isYes: Boolean) {
        loadingImpl.value = true
        val cachedAnswer = answersRepository.checkCachedAnswer()
        if (cachedAnswer != null) {
            matchAnswers(isYes, cachedAnswer)
        } else {
            doAsync {
                val remoteAnswer = answersRepository.getRemoteAnswer().body()
                uiThread {
                    if (remoteAnswer == null) {
                        errorImpl.value = "error getting answers"
                        loadingImpl.value = false
                    } else {
                        answersRepository.cacheAnswer(remoteAnswer)
                        matchAnswers(isYes, remoteAnswer)
                    }
                }
            }


        }
    }

    private fun matchAnswers(isYes: Boolean, answer: Answer) {
        if (isYes)
            answerImageImpl.value = answer.imageYes
        else
            answerImageImpl.value = answer.imageNo

        errorImpl.value = ""
        loadingImpl.value = false
    }


}
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

    private val viewStateImpl: MutableLiveData<MainViewSate> by lazy {
        MutableLiveData<MainViewSate>()
    }
    val viewState: LiveData<MainViewSate> = viewStateImpl

    init {
        viewStateImpl.value = MainViewSate()
    }


    fun handleChoice(isYes: Boolean) {
        postValue(previousValue().copy(isLoading = true))
        val cachedAnswer = answersRepository.checkCachedAnswer()
        if (cachedAnswer != null) {
            matchAnswers(isYes, cachedAnswer)
        } else {
            doAsync {
                val remoteAnswer = answersRepository.getRemoteAnswer().body()
                uiThread {
                    if (remoteAnswer == null) {
                        postValue(
                            previousValue().copy(
                                onError = "error getting answers",
                                isLoading = false
                            )
                        )
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
            postValue(
                previousValue().copy(
                    onAnswer = answer.imageYes,
                    isLoading = true,
                    onError = ""
                )
            )
        else
            postValue(
                previousValue().copy(
                    onAnswer = answer.imageNo,
                    isLoading = true,
                    onError = ""
                )
            )
    }

    fun postValue(mainViewSate: MainViewSate) {
        viewStateImpl.value = mainViewSate
    }

    fun previousValue() = viewStateImpl.value!!


}
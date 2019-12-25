package com.egdroid.arch.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egdroid.arch.model.Answer
import com.egdroid.arch.schedulers.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val answerUseCase: AnswerUseCase,
    private val schedulerProvider: BaseSchedulerProvider
) : ViewModel() {

    private val viewStateImpl: MutableLiveData<MainViewSate> by lazy {
        MutableLiveData<MainViewSate>()
    }
    val viewState: LiveData<MainViewSate> = viewStateImpl

    private val compositeDisposable = CompositeDisposable()

    init {
        viewStateImpl.value = MainViewSate()
    }


    fun handleChoice(isYes: Boolean) {
        compositeDisposable.add(answerUseCase(isYes)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe {
                postValue(previousValue().copy(isLoading = true))
            }
            .subscribe({
                if (isYes)
                    postValue(
                        previousValue().copy(
                            onAnswer = it.imageYes,
                            isLoading = true,
                            onError = ""
                        )
                    )
                else
                    postValue(
                        previousValue().copy(
                            onAnswer = it.imageNo,
                            isLoading = true,
                            onError = ""
                        )
                    )
            }, {
                postValue(
                    previousValue().copy(
                        onError = "error getting answers",
                        isLoading = false
                    )
                )
            })
        )


    }


    fun postValue(mainViewSate: MainViewSate) {
        viewStateImpl.value = mainViewSate
    }

    fun previousValue() = viewStateImpl.value!!


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
package com.egdroid.arch.main

import io.reactivex.Observable
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class AnswerUseCase @Inject constructor(private val answersRepository: AnswersRepository) {

    operator fun invoke(isYes: Boolean) =
        Observable.concat(
            answersRepository.checkCachedAnswer(),
            answersRepository.getRemoteAnswer()
        )
            .doOnNext {
                answersRepository.cacheAnswer(it)
            }

}


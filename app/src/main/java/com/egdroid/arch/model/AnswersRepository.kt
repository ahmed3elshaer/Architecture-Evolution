package com.egdroid.arch.model

import javax.inject.Inject

class AnswersRepository @Inject constructor(
    private val sharedPrefWrapper: SharedPrefWrapper,
    private val answerAPI: AnswerAPI
)
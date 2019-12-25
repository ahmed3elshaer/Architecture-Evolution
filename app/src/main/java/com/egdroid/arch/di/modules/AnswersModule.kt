/*
 * *
 *  * Created by Ahmed Elshaer on 11/10/19 3:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:12 PM
 *
 */

package com.egdroid.arch.di.modules

import com.egdroid.arch.model.AnswerAPI
import com.egdroid.arch.model.AnswersRepository
import com.egdroid.arch.model.SharedPrefWrapper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
abstract class AnswersModule {


    @Provides
    internal fun provideAnswersRepository(
        answerAPI: AnswerAPI,
        sharedPrefWrapper: SharedPrefWrapper
    ) = AnswersRepository(sharedPrefWrapper, answerAPI)

    @Provides
    internal fun provideHomeApi(retrofit: Retrofit): AnswerAPI =
        retrofit.create(AnswerAPI::class.java)




}

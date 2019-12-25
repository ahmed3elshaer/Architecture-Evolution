/*
 * *
 *  * Created by Ahmed Elshaer on 11/10/19 3:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:12 PM
 *
 */

package com.egdroid.arch.di.modules

import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {
    @Provides
    internal fun provideRetrofitInterface(client: OkHttpClient): Retrofit {

        val mochi = MoshiConverterFactory.create()
        mochi.asLenient()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(mochi)
            .client(client)
            .build()
    }

    @Provides
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    companion object {
        const val BASE_URL = "https://someWebService.com"
    }
}

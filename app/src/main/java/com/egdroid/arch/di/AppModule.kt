/*
 * *
 *  * Created by Ahmed Elshaer on 11/10/19 3:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:12 PM
 *
 */

package com.egdroid.arch.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.egdroid.arch.model.SharedPrefWrapper
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    fun provideSharedPref(context: Context): SharedPrefWrapper {
        return SharedPrefWrapper(context.getSharedPreferences("egDroidArch", Context.MODE_PRIVATE))
    }


}

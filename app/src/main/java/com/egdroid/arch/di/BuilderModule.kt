/*
 * *
 *  * Created by Ahmed Elshaer on 11/10/19 3:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:12 PM
 *
 */

package com.egdroid.arch.di


import com.egdroid.arch.main.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [AndroidInjectionModule::class])
abstract class BuilderModule {

    @AppComponent.PerActivity
    @ContributesAndroidInjector(modules = [AnswersModule::class])
    internal abstract fun bindMainActivity(): MainActivity


}

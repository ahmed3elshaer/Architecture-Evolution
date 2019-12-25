/*
 * *
 *  * Created by Ahmed Elshaer on 11/10/19 3:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/10/19 3:12 PM
 *
 */

package com.egdroid.arch.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Scope
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        BuilderModule::class]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(app: Application)

    @Scope
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PerActivity
}

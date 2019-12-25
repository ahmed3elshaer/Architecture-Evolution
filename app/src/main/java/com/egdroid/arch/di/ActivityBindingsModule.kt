package com.egdroid.arch.di

import com.egdroid.arch.di.AppComponent.PerActivity
import com.egdroid.arch.main.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector


internal abstract class ActivityBindingsModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity?
}
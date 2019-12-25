package com.egdroid.arch.main

import com.egdroid.arch.BasePresenter
import com.egdroid.arch.BaseView

interface MainContract {
    interface View : BaseView<Presenter> {
        fun renderAnswer(image:String)
        fun showError(message:String)
    }

    interface Presenter : BasePresenter<View> {
        fun handleChoice(isYes:Boolean)
    }
}
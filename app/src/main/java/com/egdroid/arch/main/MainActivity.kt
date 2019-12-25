package com.egdroid.arch.main

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.egdroid.arch.R
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswersRepository
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleChoice()
    }


    override fun renderAnswer(image: String) {
        Glide.with(this).load(image).into(image_result)
        text_no.setTextColor(Color.BLACK)
        text_yes.setTextColor(Color.BLACK)
    }

    override fun showError(message: String) {
        Toast.makeText(
            this@MainActivity,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun handleChoice() {
        text_yes.setOnClickListener {
            presenter.handleChoice(true)
        }
        text_no.setOnClickListener {
            presenter.handleChoice(false)
        }
    }


    companion object {
        const val YES_KEY = "imageYes"
        const val NO_KEY = "imageNo"
    }

}

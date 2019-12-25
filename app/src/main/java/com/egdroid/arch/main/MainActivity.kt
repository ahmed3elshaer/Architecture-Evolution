package com.egdroid.arch.main

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.egdroid.arch.R
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswersRepository
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelProvider).get(MainViewModel::class.java)

        viewModel.answerImage.observe(this, Observer { image ->
            renderAnswer(image)
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            renderLoading(isLoading)
        })

        viewModel.error.observe(this, Observer { error ->
            renderError(error)
        })
        handleChoice()
    }

    private fun handleChoice() {
        text_yes.setOnClickListener {
            viewModel.handleChoice(true)
        }
        text_no.setOnClickListener {
            viewModel.handleChoice(false)
        }
    }

    private fun renderAnswer(image: String) {
        Glide.with(this).load(image).into(image_result)
        text_no.setTextColor(Color.BLACK)
        text_yes.setTextColor(Color.BLACK)
    }

    private fun renderError(message: String) {
        Toast.makeText(
            this@MainActivity,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun renderLoading(isLoading: Boolean) {
        // TODO ba2a ana t3ebt :D
    }


    companion object {
        const val YES_KEY = "imageYes"
        const val NO_KEY = "imageNo"
    }

}

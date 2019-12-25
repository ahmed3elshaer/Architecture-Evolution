package com.egdroid.arch

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswersRepository
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var answersRepository: AnswersRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleChoice()
    }


    private fun renderAnswer(image: String) {
        Glide.with(this).load(image).into(image_result)
        text_no.setTextColor(Color.BLACK)
        text_yes.setTextColor(Color.BLACK)
    }

    private fun handleChoice() {
        text_yes.setOnClickListener {
            answerQuestion(true)
        }
        text_no.setOnClickListener {
            answerQuestion(false)
        }
    }

    private fun answerQuestion(isYes: Boolean) {
        val cachedAnswer = answersRepository.checkCachedAnswer()
        if (cachedAnswer != null) {
            matchAnswers(isYes, cachedAnswer)
        } else {
            doAsync {
                val remoteAnswer = answersRepository.getRemoteAnswer().body()
                uiThread {
                    if (remoteAnswer == null)
                        Toast.makeText(
                            this@MainActivity,
                            "error getting answers",
                            Toast.LENGTH_LONG
                        ).show()
                    else {
                        answersRepository.cacheAnswer(remoteAnswer)
                        matchAnswers(isYes, remoteAnswer)
                    }
                }
            }


        }
    }

    private fun matchAnswers(isYes: Boolean, answer: Answer) {
        if (isYes)
            renderAnswer(answer.imageYes)
        else
            renderAnswer(answer.imageNo)
    }


    companion object {
        const val YES_KEY = "imageYes"
        const val NO_KEY = "imageNo"
    }

}

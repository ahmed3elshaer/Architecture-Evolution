package com.egdroid.arch

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.egdroid.arch.model.Answer
import com.egdroid.arch.model.AnswerAPI
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNetwork()
        handleChoice()
    }

    private fun setupNetwork() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://someWebService.com")
            .build()
    }

    private fun getRemoteAnswer(): Response<Answer> {
        val answerService = retrofit.create(AnswerAPI::class.java)
        return answerService.getAnswer().execute()
    }

    private fun cacheAnswer(answer: Answer) {
        val sharedPrefrences = getSharedPreferences("egDroidArch", Context.MODE_PRIVATE)
        sharedPrefrences.edit().apply {
            putString(YES_KEY, answer.imageYes)
            putString(NO_KEY, answer.imageNo)
        }.apply()

    }

    private fun checkCachedAnswer(): Answer? {
        val sharedPrefrences = getSharedPreferences("egDroidArch", Context.MODE_PRIVATE)
        return if (sharedPrefrences.getString(YES_KEY, null) == null ||
            sharedPrefrences.getString(NO_KEY, null) == null
        )
            null
        else
            Answer(
                sharedPrefrences.getString(YES_KEY, null)!!,
                sharedPrefrences.getString(NO_KEY, null)!!
            )

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
        val cachedAnswer = checkCachedAnswer()
        if (cachedAnswer != null) {
            matchAnswers(isYes, cachedAnswer)
        } else {
            doAsync {
                val remoteAnswer = getRemoteAnswer().body()
                uiThread {
                    if (remoteAnswer == null)
                        Toast.makeText(this@MainActivity, "error getting answers", Toast.LENGTH_LONG).show()
                    else {
                        cacheAnswer(remoteAnswer)
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

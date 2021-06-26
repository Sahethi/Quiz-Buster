package com.example.quiz_buster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var tvSkippedAnswers: TextView
    lateinit var tvCorrectAnswers:TextView
    lateinit var tvTotalQuestions: TextView
    lateinit var tvUsername: TextView
    lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USERNAME)
        val numOfSkippedAnswers = intent.getIntExtra(Constants.SKIPPED_ANSWERS,-1)
        val numOfCorrectAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, -1)
        val totalNumberOfQuestions = intent.getIntExtra(Constants.TOTAL_NUMBER_OF_QUESTIONS, -1)

        tvCorrectAnswers = findViewById<TextView>(R.id.tvCorrectAnswers)
        tvSkippedAnswers = findViewById<TextView>(R.id.tvSkippedAnswers)
        tvTotalQuestions = findViewById<TextView>(R.id.tvTotalQuestion)
        tvUsername = findViewById<TextView>(R.id.tvUsername)

        tvCorrectAnswers.text = "${numOfCorrectAnswers}"
        tvSkippedAnswers.text = "${numOfSkippedAnswers}"
        tvTotalQuestions.text = "${totalNumberOfQuestions}"
        tvUsername.text = "${username}"
    }

    public fun onFinish(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

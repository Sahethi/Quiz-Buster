package com.example.quiz_buster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class QuizActivity : AppCompatActivity() {

    lateinit var progressbarQuiz: ProgressBar
    lateinit var progressbarValue: TextView
    lateinit var tvQuestion: TextView
    lateinit var image: ImageView
    lateinit var tvOptionOne: TextView
    lateinit var tvOptionTwo: TextView
    lateinit var tvOptionThree: TextView
    lateinit var tvOptionFour: TextView
    lateinit var btnSubmitQuiz: Button

    private var username: String? = null

    private val questionList = Constants.getQuestions()
    private var currentQuestion: Int = 1
    private var totalNumberOfQuestions: Int = questionList.size

    private var isOptionSelected: Boolean = false
    private var noOfCorrectAnswers: Int = 0
    private var numOfSkippedNumbers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        username = intent.getStringExtra(Constants.USERNAME)

        progressbarQuiz = findViewById<ProgressBar>(R.id.progressQuiz)
        progressbarValue = findViewById<TextView>(R.id.tvProgressValue)
        tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvOptionOne = findViewById<TextView>(R.id.tvOptionOne)
        btnSubmitQuiz = findViewById<Button>(R.id.btnSubmitQuiz)
        tvOptionTwo = findViewById<TextView>(R.id.tvOptionTwo)
        tvOptionThree = findViewById<TextView>(R.id.tvOptionThree)
        tvOptionFour = findViewById<TextView>(R.id.tvOptionFour)
        image = findViewById<ImageView>(R.id.imgQuestionImage)

        progressbarQuiz.max = totalNumberOfQuestions

        showNextQuestion()
    }

    public fun onOptionSelected(view: View){
        if(!isOptionSelected) {
            val selectedOptionViewId = view.id
            val selectedOptionNumber = getSelectedOptionNumberFromView(selectedOptionViewId)
            val correctOptionNumber = questionList.get(currentQuestion-1).correctOption

            if(correctOptionNumber == selectedOptionNumber){
                view.setBackgroundResource(R.drawable.correct_option_border)
                (view as TextView).setTextColor(getColor(R.color.success_color))
                noOfCorrectAnswers++
            }else{
                view.setBackgroundResource(R.drawable.wrong_option_border)
                (view as TextView).setTextColor(getColor(R.color.danger_color))
                val correctOptionTextView = findViewById<TextView>(getViewIdFromOptionNumber(correctOptionNumber))
                correctOptionTextView.setBackgroundResource(R.drawable.correct_option_border)
                correctOptionTextView.setTextColor(getColor(R.color.success_color))
            }
            isOptionSelected = true
        }
    }

    public fun onSubmitQuiz(view: View){
        currentQuestion++
        if(currentQuestion == totalNumberOfQuestions){
            btnSubmitQuiz.text = "Submit Quiz"
            showNextQuestion()
        }else if(currentQuestion > totalNumberOfQuestions){
            Log.i("Result", "Text ended with ${noOfCorrectAnswers} right and ${numOfSkippedNumbers} skipped answers")

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USERNAME, username)
            intent.putExtra(Constants.SKIPPED_ANSWERS, numOfSkippedNumbers)
            intent.putExtra(Constants.CORRECT_ANSWERS, noOfCorrectAnswers)
            intent.putExtra(Constants.TOTAL_NUMBER_OF_QUESTIONS, totalNumberOfQuestions)
            startActivity(intent)
            finish()
        }else{
            showNextQuestion()
        }
    }
    private fun showNextQuestion(){
        if(!isOptionSelected){
            numOfSkippedNumbers++
        }
        progressbarQuiz.progress = currentQuestion
        progressbarValue.text = "${currentQuestion} / ${totalNumberOfQuestions}"

        val question: Question = questionList.get(currentQuestion - 1)

        tvQuestion.text = question.body

        if(!question.hasImage){
            image.setImageResource(question.image)
        }else{
            image.setImageResource(question.image)
        }

        tvOptionOne.text = question.options.get(0)
        tvOptionTwo.text = question.options.get(1)
        tvOptionThree.text = question.options.get(2)
        tvOptionFour.text = question.options.get(3)

        isOptionSelected = false
        setDefaultStateOfOptions()
    }

    private fun getSelectedOptionNumberFromView(id: Int): Int{
        when(id){
            tvOptionOne.id -> return 1
            tvOptionTwo.id -> return 2
            tvOptionThree.id -> return 3
            tvOptionFour.id -> return 4
            else -> return 0
        }
    }

    private fun getViewIdFromOptionNumber(optionNumber: Int): Int{
        when(optionNumber){
            1 -> return tvOptionOne.id
            2 -> return tvOptionTwo.id
            3 -> return tvOptionThree.id
            4 -> return tvOptionFour.id
            else -> return 0
        }
    }

    private fun setDefaultStateOfOptions(){
        tvOptionOne.setBackgroundResource(R.drawable.default_border)
        tvOptionTwo.setBackgroundResource(R.drawable.default_border)
        tvOptionThree.setBackgroundResource(R.drawable.default_border)
        tvOptionFour.setBackgroundResource(R.drawable.default_border)

        tvOptionOne.setTextColor(getColor(R.color.primary_text_color))
        tvOptionTwo.setTextColor(getColor(R.color.primary_text_color))
        tvOptionThree.setTextColor(getColor(R.color.primary_text_color))
        tvOptionFour.setTextColor(getColor(R.color.primary_text_color))

    }
}
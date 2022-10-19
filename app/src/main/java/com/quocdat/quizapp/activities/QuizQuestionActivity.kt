package com.quocdat.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quocdat.quizapp.R
import com.quocdat.quizapp.models.Question
import com.quocdat.quizapp.utils.Constants

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionList = Constants.getQuestion()
    }
}
package com.quocdat.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quocdat.quizapp.R
import com.quocdat.quizapp.utils.Constants
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        tv_name.text = intent.getStringExtra(Constants.USER_NAME)
        tv_score.text = "Your score is $correctAnswer out of $totalQuestion"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
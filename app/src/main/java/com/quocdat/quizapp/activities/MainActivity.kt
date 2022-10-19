package com.quocdat.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.quocdat.quizapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if (et_name.text?.isEmpty() == true){
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_LONG).show()
            }else{
                startActivity(Intent(this, QuizQuestionActivity::class.java))
                finish()
            }
        }
    }
}
package com.quocdat.quizapp.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import com.quocdat.quizapp.R
import com.quocdat.quizapp.models.Question
import com.quocdat.quizapp.utils.Constants
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()

        setQuestion()

        option_one?.setOnClickListener(this)
        option_two?.setOnClickListener(this)
        option_three?.setOnClickListener(this)
        option_four?.setOnClickListener(this)

        btn_submit.setOnClickListener(this)
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                option_one?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }

            2 -> {
                option_two?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }

            3 -> {
                option_three?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }

            4 -> {
                option_four?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,
                    drawableView
                )
            }
        }
    }

    private fun setQuestion() {
        optionDefaultView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition/${progressBar.max}"
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
        option_four.text = question.optionFour



        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        optionDefaultView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor((Color.parseColor("#363A43")))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun optionDefaultView(){
        val options = ArrayList<TextView>()
        option_one.let {
            options.add(0, it)
        }
        option_two.let {
            options.add(1, it)
        }
        option_three.let {
            options.add(2, it)
        }
        option_four.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one -> {
                option_one?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.option_two -> {
                option_two?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.option_three -> {
                option_three?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.option_four -> {
                option_four?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else ->{
                            Log.i("ITEM_ERROR", "onClick: ")
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList!![mCurrentPosition - 1]
                    if (question.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }
}
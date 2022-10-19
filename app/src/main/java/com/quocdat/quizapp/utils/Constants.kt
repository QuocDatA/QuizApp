package com.quocdat.quizapp.utils

import com.quocdat.quizapp.R
import com.quocdat.quizapp.models.Question

object Constants {

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Brazil",
            "Chile", "Campuchia", 1
        )
        questionList.add(question1)

        val question2 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina", "Brazil",
            "Kuwait", "Campuchia", 1
        )
        questionList.add(question2)

        val question3 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Argentina", "India",
            "Chile", "Campuchia", 1
        )
        questionList.add(question3)

        val question4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Argentina", "Brazil",
            "Chile", "Germany", 1
        )
        questionList.add(question4)

        val question5 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina", "Brazil",
            "Fiji", "Campuchia", 1
        )
        questionList.add(question5)

        val question6 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina", "Brazil",
            "Chile", "Australia", 1
        )
        questionList.add(question6)

        val question7 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina", "Belgium",
            "Chile", "Campuchia", 1
        )
        questionList.add(question7)

        val question8 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina", "Brazil",
            "Chile", "Campuchia", 1
        )
        questionList.add(question8)

        val question9 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina", "Brazil",
            "Chile", "Denmark", 1
        )
        questionList.add(question9)

        return  questionList
    }
}
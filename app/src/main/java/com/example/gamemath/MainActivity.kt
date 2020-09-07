package com.example.gamemath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var operator: String = ""
    private var x: Int = 0
    private var y: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        playGame()
    }

    private fun playGame() {
        tvlevel.text = "level ${y + 1}"
        firstNumber = generateRandomNumbers(1, 20)
        secondNumber = generateRandomNumbers(1, 20)
        operator = generateRandomOperators()
        if (operator == "/") firstNumber *= secondNumber
        tvoperator.text = "$firstNumber $operator $secondNumber = ?"
        generateWrongAnswers()
    }

    fun variantClick(answer: View) {
        if ((answer as Button).text == getRightAnswers().toString()) {
            x++
            y++
        } else y++
        val intent = Intent(this, ResultActivity::class.java)
        if (y == 10) {
            intent.putExtra("result", "$x/$y")
            y = 0
            x = 0
            startActivity(intent)
        } else {
            tvlevel.text = "level ${y + 1}"
            firstNumber = generateRandomNumbers(1, 20)
            secondNumber = generateRandomNumbers(1, 20)
            operator = generateRandomOperators()

            if (operator == "/") firstNumber *= secondNumber

            tvoperator.text = "$firstNumber $operator $secondNumber = ?"
            generateWrongAnswers()
        }
    }

    private fun generateWrongAnswers() {
        var var1 = generateRandomNumbers(1, 15)
        btnA.text = var1.toString()
        var var2 = generateRandomNumbers(16, 30)
        btnB.text = var2.toString()
        var var3 = generateRandomNumbers(31, 45)
        btnC.text = var3.toString()
        var var4 = generateRandomNumbers(46, 60)
        btnD.text = var4.toString()

        when (generateRandomNumbers(1, 4)) {
            1 -> btnA.text = getRightAnswers().toString()
            2 -> btnB.text = getRightAnswers().toString()
            3 -> btnC.text = getRightAnswers().toString()
            4 -> btnD.text = getRightAnswers().toString()
            else -> btnA.text = getRightAnswers().toString()
        }
    }

    private fun getRightAnswers(): Int {
        var juwap = 0
        when (operator) {
            "+" -> juwap = firstNumber + secondNumber
            "-" -> juwap = firstNumber - secondNumber
            "*" -> juwap = firstNumber * secondNumber
            "/" -> juwap = firstNumber / secondNumber
        }
        return juwap
    }

    private fun generateRandomNumbers(start: Int, end: Int): Int = Random.nextInt(start, end)
    private fun generateRandomOperators(): String {
        val random = Random.nextInt(0, 4)
        operator = when (random) {
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> "+"
        }
        return operator
    }
}
package com.example.rowreduction

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.arrayOf as arrayOf1

class MainActivity : AppCompatActivity() {

    var buttonIDs = arrayOf1(
        R.id.button0,
        R.id.button1,
        R.id.button2,
        R.id.button3,
        R.id.button4,
        R.id.button5,
        R.id.button6,
        R.id.button7,
        R.id.button8,
        R.id.button9,
        R.id.buttonDEL,
        R.id.buttonPlusMinus,
        R.id.setupMatrix,
        R.id.buttonDot,
        R.id.buttonLeft,
        R.id.buttonRight,
        R.id.buttonFrac
    )

    var equationIDs = arrayOf1(
        arrayOf1(R.id.coefficientX1, R.id.coefficientY1,R.id.coefficientC1),
        arrayOf1(R.id.coefficientX2, R.id.coefficientY2, R.id.coefficientC2)
    )

    var coefficients = arrayOf1(
        arrayOf1("0", "0", "0"),
        arrayOf1("0", "0", "0")
    )

    var row = 0
    var column = 0
    var numberOfEquations = 2
    var numberOfVariables = 2

    lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(equationIDs[row][column])


        for(buttonID in buttonIDs) {
            val b: Button = findViewById(buttonID)

            b.setOnClickListener {

                if (buttonID == R.id.buttonFrac) {
                    val intent = Intent(this,MainActivity2::class.java)
                    intent.putExtra("key",coefficients[row][column])
                    intent.putExtra("Number",coefficients[row][column])
                    
                }
                else if( (buttonID == R.id.buttonLeft) || (buttonID == R.id.buttonRight)) {
                    moveBox(buttonID)
                }
                else {
                    editNumber(buttonID)
                }
            }
        }
    }

    fun moveBox(direction: Int) {

        textViewResult = findViewById(equationIDs[row][column])
        textViewResult.setBackgroundColor(Color.TRANSPARENT)


        when (direction) {
            R.id.buttonLeft -> {
                // move left
                column -= 1

                if(column < 0) {
                    row -= 1
                    column = numberOfVariables

                    if(row < 0) {
                        row = 0
                    }
                }
            }
            R.id.buttonRight -> {
                // move right
                column += 1

                if(column > numberOfVariables) {
                    row += 1
                    column = 0

                    if(row == numberOfEquations) {
                        row = 0
                    }
                }
            }
            else -> {
                println("ERROR")
            }
        }

        textViewResult = findViewById(equationIDs[row][column])
        textViewResult.setBackgroundResource(R.drawable.my_border)
    }

    fun editNumber(id: Int) {


        if(coefficients[row][column] == "0") {
            coefficients[row][column] = ""
        }

        val tempResult: String

        when (id) {
            R.id.button0 -> {
                if(coefficients[row][column] == "0") {
                    return
                }
                if( (coefficients[row][column].contains(".", false)) && (coefficients[row][column].last() == '0')) {
                    return
                }
                coefficients[row][column] += "0"
            }
            R.id.button1 -> {
                coefficients[row][column] += "1"
            }
            R.id.button2 -> {
                coefficients[row][column] += "2"
            }
            R.id.button3 -> {
                coefficients[row][column] += "3"
            }
            R.id.button4 -> {
                coefficients[row][column] += "4"
            }
            R.id.button5 -> {
                coefficients[row][column] += "5"
            }
            R.id.button6 -> {
                coefficients[row][column] += "6"
            }
            R.id.button7 -> {
                coefficients[row][column] += "7"
            }
            R.id.button8 -> {
                coefficients[row][column] += "8"
            }
            R.id.button9 -> {
                coefficients[row][column] += "9"
            }
            R.id.buttonDEL -> {

                tempResult = coefficients[row][column].dropLast(1)
                coefficients[row][column] = tempResult

                if(coefficients[row][column] == "") {
                    coefficients[row][column] = "0"
                }
            }
            R.id.buttonPlusMinus -> {
                if(coefficients[row][column].contains("-", true)) {
                    // remove -
                    tempResult = coefficients[row][column].drop(1)
                    coefficients[row][column] = tempResult
                }
                else {
                    val temp = coefficients[row][column]
                    coefficients[row][column] = "-$temp"
                }

                if(coefficients[row][column] == "-") {
                    coefficients[row][column] = "0"
                }
            }
            R.id.buttonDot -> {
                println("pressing dot")
                if(coefficients[row][column].contains(".")) {
                    return
                }
                coefficients[row][column] += "."

                if(coefficients[row][column] == ".") {
                    coefficients[row][column] = "0."
                }
            }
            else -> {
                println("Error")
            }
        }

        println(coefficients[row][column])
        textViewResult = findViewById(equationIDs[row][column])
        textViewResult.text = coefficients[row][column]
    }

}
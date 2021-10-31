package com.example.rowreduction

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.internal.ContextUtils.getActivity
import java.lang.Float.parseFloat
import java.util.ArrayList
//import kotlin.arrayOf as arrayOf1
import java.util.Arrays

class MainActivity : AppCompatActivity() {

    private var buttonIDs = arrayOf(
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

    private var equationIDs = arrayOf(
        arrayOf(R.id.coefficientX1, R.id.coefficientY1,R.id.coefficientZ1, R.id.coefficientC1),
        arrayOf(R.id.coefficientX2, R.id.coefficientY2, R.id.coefficientZ2, R.id.coefficientC2),
        arrayOf(R.id.coefficientX3, R.id.coefficientY3, R.id.coefficientZ3, R.id.coefficientC3)
    )

    // variable containing all coefficients
    var matrix = Matrix()


    var row = 0
    var column = 0
    var numberOfEquations = 3
    var numberOfVariables = 3

    lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // current selected box
        textViewResult = findViewById(equationIDs[row][column])

        // add listeners to all the buttons
        for(buttonID in buttonIDs) {
            val b: Button = findViewById(buttonID)

            b.setOnClickListener {

                if( (buttonID == R.id.buttonLeft) || (buttonID == R.id.buttonRight)) {
                    moveBox(buttonID)
                }
                else if(buttonID == R.id.setupMatrix) {
                     if (validate()) {
                         // move to next screen
                         setupAugmentedMatrix()
                     }
                }
                else {
                    editNumber(buttonID)
                }
            }
        }
    }

    fun setupAugmentedMatrix() {

        val intent = Intent(this,MainActivity2::class.java)

        // set data up to send to next activity
        for(i in matrix.coefficients[0].indices) {
//            println(matrix.coefficients[0][i])
        }
        intent.putExtra("coefficients1", matrix.coefficients[0])
        intent.putExtra("coefficients2", matrix.coefficients[1])
        intent.putExtra("coefficients3", matrix.coefficients[2])

        startActivity(intent)
    }

    // make sure the number is valid
    private fun validate() : Boolean {

        // search through coefficients. make sure they're all valid numbers
        // if they're all numbers, convert to Rational
        for(i in matrix.coefficients.indices) {
            for (j in matrix.coefficients[i].indices) {

                // if the string to rational returns false, return false for validate
                if (!matrix.stringToRational(i,j)) {
                    Toast.makeText(
                        this,
                        "One of your coefficients is invalid.",
                        Toast.LENGTH_LONG
                    ).show()
                    return false
                }
            }
        }
        return true
    }

    private fun moveBox(direction: Int) : Boolean {

        if(!validate()) {
            println("SOMETHING WENT WRONG")
            return false
        }
        else {
            textViewResult = findViewById(equationIDs[row][column])
            textViewResult.setBackgroundColor(Color.TRANSPARENT)
        }

        when (direction) {
            R.id.buttonLeft -> {
                // move left
                column -= 1

                if(column < 0) {
                    row -= 1
                    column = numberOfVariables

                    if(row < 0) {
                        row = (numberOfEquations-1)
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

        return true
    }

    private fun editNumber(id: Int) {


        if(matrix.coefficients[row][column] == "0") {
            matrix.coefficients[row][column] = ""
        }

        val tempResult: String

        when (id) {
            R.id.button0 -> {
                // don't add a 0 if the number is already 0
                if(matrix.coefficients[row][column] == "0") {
                    return
                }
                // don't add a zero if the decimal already ends in a 0
                if( (matrix.coefficients[row][column].contains(".", false)) && (matrix.coefficients[row][column].last() == '0')) {
                    return
                }
                matrix.coefficients[row][column] += "0"
            }
            R.id.button1 -> {
                matrix.coefficients[row][column] += "1"
            }
            R.id.button2 -> {
                matrix.coefficients[row][column] += "2"
            }
            R.id.button3 -> {
                matrix.coefficients[row][column] += "3"
            }
            R.id.button4 -> {
                matrix.coefficients[row][column] += "4"
            }
            R.id.button5 -> {
                matrix.coefficients[row][column] += "5"
            }
            R.id.button6 -> {
                matrix.coefficients[row][column] += "6"
            }
            R.id.button7 -> {
                matrix.coefficients[row][column] += "7"
            }
            R.id.button8 -> {
                matrix.coefficients[row][column] += "8"
            }
            R.id.button9 -> {
                matrix.coefficients[row][column] += "9"
            }
            R.id.buttonDEL -> {

                tempResult = matrix.coefficients[row][column].dropLast(1)
                matrix.coefficients[row][column] = tempResult

                if(matrix.coefficients[row][column] == "") {
                    matrix.coefficients[row][column] = "0"
                }
            }
            R.id.buttonPlusMinus -> {
                if(matrix.coefficients[row][column].contains("-", true)) {
                    // remove -
                    tempResult = matrix.coefficients[row][column].drop(1)
                    matrix.coefficients[row][column] = tempResult
                }
                else {
                    val temp = matrix.coefficients[row][column]
                    matrix.coefficients[row][column] = "-$temp"
                }

                if(matrix.coefficients[row][column] == "-") {
                    matrix.coefficients[row][column] = "0"
                }
            }
            R.id.buttonDot -> {

                if(matrix.coefficients[row][column].contains(".")) {
                    return
                }

                if(matrix.coefficients[row][column].contains("/")){
                    return
                }

                matrix.coefficients[row][column] += "."

                if(matrix.coefficients[row][column] == ".") {
                    matrix.coefficients[row][column] = "0."
                }
            }
            R.id.buttonFrac -> {

                // don't add a fraction if it has a / or decimal.
                if (matrix.coefficients[row][column].contains("/") || matrix.coefficients[row][column].contains(".") ) {
                    return
                }
                matrix.coefficients[row][column] += "/"

                // don't show / if it's the only text shown
                if(matrix.coefficients[row][column] == "/") {
                   matrix.coefficients[row][column] = "0"
                }
            }
            else -> {
                println("Error")
            }
        }

        //println(coefficients[row][column])
        textViewResult = findViewById(equationIDs[row][column])
        textViewResult.text = matrix.coefficients[row][column]
    }

}
package com.example.rowreduction

import android.widget.Toast
import java.lang.Float

class Matrix {

    var coefficients = arrayOf(
        arrayOf("0", "0", "0", "0"),
        arrayOf("0", "0", "0", "0"),
        arrayOf("0", "0", "0", "0")
    )

    var coefficientsAsRationals = arrayOf(
        arrayOf(Rational(0,1),Rational(0,1),Rational(0,1),Rational(0,1) ),
        arrayOf(Rational(0,1),Rational(0,1),Rational(0,1),Rational(0,1) ),
        arrayOf(Rational(0,1),Rational(0,1),Rational(0,1),Rational(0,1) )
    )

    fun stringToRational(i: Int, j: Int) : Boolean {

        if (this.coefficients[i][j] == "0") {
            this.coefficientsAsRationals[i][j].num = 0
            this.coefficientsAsRationals[i][j].den = 1
            return true
        }

        if (this.coefficients[i][j].contains("/")) {
            val numbers = coefficients[i][j].split("/")

            // check if the numerator and denominator are actual numbers
            return try {
                val numerator = Float.parseFloat(numbers[0])
                val denominator = Float.parseFloat(numbers[1])
                this.coefficientsAsRationals[i][j].num = numerator.toLong()
                this.coefficientsAsRationals[i][j].den = denominator.toLong()
                true
            } catch (e: NumberFormatException) {
                println(e)
                false
            }
        }

        if (!this.coefficients[i][j].contains('.')) {
            this.coefficientsAsRationals[i][j].num = this.coefficients[i][j].toLong()
            this.coefficientsAsRationals[i][j].den = 1
            return true
        }

        val ds = this.coefficients[i][j].trimEnd('0').trimEnd('.')
        val index = ds.indexOf('.')
        if (index == -1) {
            this.coefficientsAsRationals[i][j].num = ds.toLong()
            this.coefficientsAsRationals[i][j].den = 1L
        }
        var num = ds.replace(".", "").toLong()
        var den = 1L
        for (n in 1 until ds.length - index) den *= 10L
        while (num % 2L == 0L && den % 2L == 0L) {
            num /= 2L
            den /= 2L
        }
        while (num % 5L == 0L && den % 5L == 0L) {
            num /= 5L
            den /= 5L
        }
        this.coefficientsAsRationals[i][j].num = num
        this.coefficientsAsRationals[i][j].den = den
//        println("$num/$den")

        return true

    }

    fun swapRows(rowI: Int, rowJ: Int) {

        val i = rowI - 1
        val j = rowJ - 1

        for (column in this.coefficients[i].indices) {
            // store i row in tempRow
            val temp = this.coefficients[i][column]
            this.coefficients[i][column] = this.coefficients[j][column]
            this.coefficients[j][column] = temp
            this.stringToRational(i,column)
            this.stringToRational(j,column)
        }
    }

    // https://rosettacode.org/wiki/Convert_decimal_number_to_rational#Kotlin
    fun decimalToRational(d: Double): Rational {
        val ds = d.toString().trimEnd('0').trimEnd('.')
        val index = ds.indexOf('.')
        if (index == -1) return Rational(ds.toLong(), 1L)
        var num = ds.replace(".", "").toLong()
        var den = 1L
        for (n in 1 until ds.length - index) den *= 10L
        while (num % 2L == 0L && den % 2L == 0L) {
            num /= 2L
            den /= 2L
        }
        while (num % 5L == 0L && den % 5L == 0L) {
            num /= 5L
            den /= 5L
        }

        println("$num/$den")
        return Rational(num, den)
    }

}
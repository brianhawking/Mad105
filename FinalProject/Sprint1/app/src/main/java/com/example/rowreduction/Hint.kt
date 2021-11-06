package com.example.rowreduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Hint : AppCompatActivity() {

    var matrix = Matrix()
    var numberOfEquations = 3
    var numberOfVariables = 3
    var pivotRow = 0
    var pivotColumn = 0

    val ZERO = Rational(0,1)
    val ONE = Rational(1,1)

    var hintViews = arrayOf(
        R.id.swapRowsHint,
        R.id.multiplyByConstantHint,
        R.id.rowPlusConstantRowHint
    )

    var rowImages = arrayOf(
        R.drawable.r1,
        R.drawable.r2,
        R.drawable.r3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        // get coefficients from previous activity
        val bundle: Bundle? = intent.extras
        val coefficients1 = bundle?.getStringArray("coefficients1")
        val coefficients2 = bundle?.getStringArray("coefficients2")
        val coefficients3 = bundle?.getStringArray("coefficients3")
        numberOfEquations = bundle?.getInt("numberOfEquations")!!
        numberOfVariables = bundle.getInt("numberOfVariables")

        // get data from bundle. Store it in the matrix as string and rational
        for (i in matrix.coefficients.indices) {
            for (j in matrix.coefficients[i].indices) {
                when (i) {
                    0 ->  matrix.coefficients[i][j] = coefficients1?.get(j).toString()
                    1 ->  matrix.coefficients[i][j] = coefficients2?.get(j).toString()
                    2 ->  matrix.coefficients[i][j] = coefficients3?.get(j).toString()
                    else -> println("SOMETHING BAD HAPPENED")
                }
                // create the Rational version of the number
                matrix.stringToRational(i,j)
            }
        }

        val doneButton: Button = findViewById(R.id.doneButton)
        doneButton.setOnClickListener {
            finish()
        }

        for (linearlayoutID in hintViews) {
            val layout: LinearLayout = findViewById(linearlayoutID)
            layout.visibility = View.GONE
        }

        findPivot()

    }

    fun findPivot() {

        println("Row $pivotRow, Column $pivotColumn")
        if(pivotColumn == numberOfVariables) {
            readTable()
        }
        // is pivot column a unit column

        val ones = arrayOf(false, false, false)
        val zeros = arrayOf(false, false, false)
        val nonzeros = arrayOf(false, false, false)


        for (row in 0 until numberOfEquations) {

            val number = matrix.coefficientsAsRationals[row][pivotColumn]
            println("${number.num} / ${number.den}")

            when {
                number.equals(ONE) -> {
                    ones[row] = true
                }
                number.equals(ZERO) -> {
                    zeros[row] = true
                }
                else -> {
                    nonzeros[row] = true
                }
            }
        }



        println("1s: ${ones.count {it}}")
        println("0s: ${zeros.count {it}}")
        println("nons: ${nonzeros.count {it}}")



        if (zeros.count {it} == (numberOfEquations)) {
            println("COLUMN does not have a pivot. Move to next column")
            pivotColumn += 1
            if(pivotColumn == numberOfVariables) {
                readTable()
            }
            else {
                findPivot()
            }
        }
        // you have a unit column
        else if (ones.count {it} >= 1){
            // this is a unit column
            if (ones[pivotRow] && zeros.count{it} == (numberOfEquations-1)) {
                println("GO TO next column")
                pivotRow += 1
                pivotColumn += 1
                if(pivotColumn == numberOfVariables) {
                    readTable()
                }
                else {
                    findPivot()
                }

            }
            else if (ones[pivotRow]) {
                println(" GO TO OPERATION 3")
                operation3Step(nonzeros.indexOf(true))
            }
            else {
                operation1Step(ones.indexOf(true))
            }
        }
        else {
            // a non zero exists
            val number = matrix.coefficientsAsRationals[pivotRow][pivotColumn]
            if (number.equals(ZERO)) {
                // swap with another row
                var counter = 0
                for (row in nonzeros.indices) {
                    if (row == numberOfEquations) {
                        break
                    }
                    if (nonzeros[row] && row > pivotRow) {
                        operation1Step(row)
                        break
                    }
                    counter += 1
                }

                println("counter is $counter")
                if(counter == numberOfEquations) {
                    pivotColumn += 1
                    if(pivotColumn == numberOfVariables) {
                        readTable()
                    }
                    else {
                        findPivot()
                    }
                }


            }
            else {
                // turn into a 1
                operation2Step(pivotRow)
            }
        }
    }

    fun showHint(hint: Int) {
       val layout: LinearLayout = findViewById(hintViews[hint])
       layout.visibility = View.VISIBLE
    }

    fun operation1Step(row: Int) {
        showHint(0)
        val rowI: ImageView = findViewById(R.id.operation1RowI)
        val rowJ: ImageView = findViewById(R.id.operation1RowJ)

        rowI.setImageResource(rowImages[pivotRow])
        rowJ.setImageResource(rowImages[row])
        println("Swap Row ${pivotRow+1} with Row ${row+1}")
    }

    fun operation2Step(row: Int) {
        showHint(1)
        val operation2Constant: TextView = findViewById(R.id.operation2Constant)
        val operation2InitialRow: ImageView = findViewById(R.id.operation2InitialRow)
        val operation2FinalRow: ImageView = findViewById(R.id.operation2FinalRow)

        val number = matrix.coefficientsAsRationals[row][pivotColumn]
        operation2Constant.text = number.reciprocal().toString()
        operation2InitialRow.setImageResource(rowImages[pivotRow])
        operation2FinalRow.setImageResource(rowImages[pivotRow])


        println("Multiply Row ${row+1} by ${number.reciprocal()}")
    }

    fun operation3Step(row: Int) {
        showHint(2)

        val operation3Constant: TextView = findViewById(R.id.operation3Constant)
        val operation3InitialRow: ImageView = findViewById(R.id.operation3initialRow)
        val operation3PivotRow: ImageView = findViewById(R.id.operation3PivotRow)
        val operation3FinalRow: ImageView = findViewById(R.id.operation3FinalRow)

        val number = matrix.coefficientsAsRationals[row][pivotColumn]
        operation3Constant.text = number.negate().toString()
        operation3InitialRow.setImageResource(rowImages[row])
        operation3FinalRow.setImageResource(rowImages[row])
        operation3PivotRow.setImageResource(rowImages[pivotRow])
        println("Row ${row+1} + ${number.negate()} * Row ${pivotRow+1}")
    }

    fun readTable() {
        val hintText: TextView = findViewById(R.id.hintText)
        hintText.text = "You're done!"
    }

}
package com.example.rowreduction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.util.*
import java.util.Arrays.toString

class MainActivity2 : AppCompatActivity() {

    var resultContractForSwap = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult? ->
        if((result?.resultCode == Activity.RESULT_OK)){

            val intent = result.data
            val bundle: Bundle? = intent?.extras
            val rows = bundle?.getIntArray("rows")

            println("bundle: $rows")

            if (rows != null) {
                rows.forEach {
                    println("data: $it")
                }
            }
            else {
                println("Rows is null")
            }

            rows?.get(0)?.let { matrix.swapRows(it, rows?.get(1)) }

            updateScreen()
        }
    }

    private var equationIDs = arrayOf(
        arrayOf(R.id.coefficientX1, R.id.coefficientY1,R.id.coefficientZ1, R.id.coefficientC1),
        arrayOf(R.id.coefficientX2, R.id.coefficientY2, R.id.coefficientZ2, R.id.coefficientC2),
        arrayOf(R.id.coefficientX3, R.id.coefficientY3, R.id.coefficientZ3, R.id.coefficientC3)
    )

    var matrix = Matrix()

    var row = 0
    var column = 0
    var numberOfEquations = 3
    var numberOfVariables = 3

    lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // get coefficients from previous activity
        val bundle: Bundle? = intent.extras
        val coefficients1 = bundle?.getStringArray("coefficients1")
        val coefficients2 = bundle?.getStringArray("coefficients2")
        val coefficients3 = bundle?.getStringArray("coefficients3")

        // get data from bundle. Store it in the matrix
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

        // display data to the matrix on screen
        updateScreen()



        // set listeners on the row operation buttons
        val swapRowsButton: ImageButton = findViewById(R.id.swapRows)
        val multByConstantButton: ImageButton = findViewById(R.id.multByConstant)
        val multBy: ImageButton = findViewById(R.id.rowPlusConstantRow)

        swapRowsButton.setOnClickListener {
            val intent = Intent(this,SwapRows::class.java)
            resultContractForSwap.launch(intent)
        }


//        val rational = matrix.coefficientsAsRationals[0][0] + matrix.coefficientsAsRationals[0][1]

    }

    fun updateScreen() {
        for(i in equationIDs.indices) {
            for(j in equationIDs[i].indices) {
                var box: TextView = findViewById(equationIDs[i][j])
                box.text = matrix.coefficientsAsRationals[i][j].toString()
            }
        }
    }

}
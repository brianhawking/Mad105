package com.example.mealtip

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var cost: Double = 0.0
    var tipPercentage: Double = 0.0
    var tip: Double = 0.0
    var totalCost: Double = 0.0



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get user input
        val mealCost: EditText = findViewById(R.id.idText_MealCost)
        val tipGroup: Spinner = findViewById(R.id.IdSpinner_tip)
        val calculateButton: Button = findViewById(R.id.IdButton_calculate)
        val result: TextView = findViewById(R.id.idText_result)

        // code to run when clicking "calculate" button
        calculateButton.setOnClickListener{

            cost = mealCost.text.toString().toDouble()
            val tipString = tipGroup.selectedItem.toString()
            val currency = DecimalFormat("$##,###.00")

            when (tipString) {
                "5%" -> tipPercentage = 0.05
                "10%" -> tipPercentage = 0.10
                "15%" -> tipPercentage = 0.15
                "20%" -> tipPercentage = 0.20
                "25%" -> tipPercentage = 0.25
            }

            tip = cost * tipPercentage
            totalCost = cost + tip

            val tipFormatted = currency.format(tip)
            val costFormatted = currency.format(totalCost)

            result.text = "Tip: $tipFormatted, Final Cost: $costFormatted"

        }
    }
}
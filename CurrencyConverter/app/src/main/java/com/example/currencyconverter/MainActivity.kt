package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

/**
 * Class - MainActivity
 * @author - Brian Veitch
 * @date - 11/6

 * @description
 * Asks user for conversion type and currency. App will convert the entered amount to the
 * new currency.

 * @param
 * currencyInput - currency from user
 * radio_::Type:: - different radio button conversions
 * euroToDollarConversion - conversion rate for E -> $
 * resultsCurrency - result after conversion
 *
 * mods
 * BV
 */

class MainActivity : AppCompatActivity() {


    // exchange rate as of 11/7/2021 10am
    private val euroToDollarConversion: Double = 1.156268

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher2)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        // get data from input
        val currencyInput: TextView = findViewById(R.id.editTextCurrency)
        val dollarToEuro: RadioButton = findViewById(R.id.Radio_dollarToEuro)
        val euroToDollar: RadioButton = findViewById(R.id.Radio_euroToDollar)
        val convertButton: Button = findViewById(R.id.button_convert)
        val resultTextView: TextView = findViewById(R.id.textView_result)
        var resultCurrency: Double?

        convertButton.setOnClickListener {

            val currencyFormatter = DecimalFormat("#.##")

            // check if currency input is empty
            if (currencyInput.text.toString() == "") {
                Toast.makeText(this@MainActivity, "You forgot to enter a number to convert.", Toast.LENGTH_LONG).show()
            }
            else {
                val currencyToConvert = currencyInput.text.toString().toDouble()

                // check which radio button is selected
                if (dollarToEuro.isChecked) {
                    // convert to euro
                    resultCurrency = currencyToConvert / euroToDollarConversion
                    resultTextView.text = "\u20ac" + currencyFormatter.format(resultCurrency)

                    // check if they have over $10,000 (dollars)
                    if (currencyToConvert > 10000.00) {
                        Toast.makeText(this@MainActivity, "You are converting over $10,000 to Euros!", Toast.LENGTH_LONG).show()
                    }
                }
                else if (euroToDollar.isChecked) {
                    // convert tto dollar
                    resultCurrency = currencyToConvert * euroToDollarConversion
                    resultTextView.text = "$" + currencyFormatter.format(resultCurrency)
                    // check if they are converting to over $10000 (dollars)
                    if (resultCurrency!! > 10000.00) {
                        Toast.makeText(this@MainActivity, "You are converting to over $10,000", Toast.LENGTH_LONG).show()
                    }
                }
                else {
                    // something's wrong
                    Toast.makeText(this@MainActivity, "You did not select a conversion.",Toast.LENGTH_LONG).show()
                }
            }
        }


    }
}
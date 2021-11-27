package com.example.mccfollowalongprojectpt2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class ChooseClass : AppCompatActivity() {

    private var firstName: String? = ""
    private var lastName: String? = ""
    private var phone: String? = ""
    private var birthDate: String? = ""
    private var isDegreeCert: String? = ""
    private var degreeCertification: String? = ""

    private var ctv1: CheckedTextView? = null
    private var ctv2: CheckedTextView? = null
    private var ctv3: CheckedTextView? = null
    private var ctv4: CheckedTextView? = null

    private var rb1: RadioButton? = null
    private var rb2: RadioButton? = null
    private var rb3: RadioButton? = null
    private var rb4: RadioButton? = null
    private var rb5: RadioButton? = null
    private var rb6: RadioButton? = null
    private var rb7: RadioButton? = null
    private var rb8: RadioButton? = null

    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null
    private var rg4: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        ctv1 = findViewById(R.id.ctv1)
        ctv2 = findViewById(R.id.ctv2)
        ctv3 = findViewById(R.id.ctv3)
        ctv4 = findViewById(R.id.ctv4)

        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        rb5 = findViewById(R.id.rb5)
        rb6 = findViewById(R.id.rb6)
        rb7 = findViewById(R.id.rb7)
        rb8 = findViewById(R.id.rb8)

        val nextButton: Button = findViewById(R.id.nextButton)

        val extras = intent.extras

        if(extras != null) {
            firstName = extras.getString("firstName")
            lastName = extras.getString("lastName")
            phone = extras.getString("phone")
            birthDate = extras.getString("birthday")
            isDegreeCert = extras.getString("isDegreeCert")
            degreeCertification = extras.getString("degreeCert")
        }

        nextButton.setOnClickListener {
            var radioButton: RadioButton
            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""

            var radio1Text = ""
            var radio2Text = ""
            var radio3Text = ""
            var radio4Text = ""

            rg1 = findViewById(R.id.radioGroup1)
            rg2 = findViewById(R.id.radioGroup2)
            rg3 = findViewById(R.id.radioGroup3)
            rg4 = findViewById(R.id.radioGroup4)

            val selectedTimes = arrayOf(0,0,0,0)

            if (ctv1!!.isChecked) {
                ctv1Text = ctv1!!.text.toString()
                selectedTimes[0] = rg1!!.checkedRadioButtonId
                radioButton = findViewById(selectedTimes[0])
                radio1Text = radioButton.text.toString()
            }

            if (ctv2!!.isChecked) {
                ctv2Text = ctv2!!.text.toString()
                selectedTimes[1] = rg2!!.checkedRadioButtonId
                radioButton = findViewById(selectedTimes[1])
                radio2Text = radioButton.text.toString()
            }

            if (ctv3!!.isChecked) {
                ctv3Text = ctv3!!.text.toString()
                selectedTimes[2] = rg3!!.checkedRadioButtonId
                radioButton = findViewById(selectedTimes[2])
                radio3Text = radioButton.text.toString()
            }

            if (ctv4!!.isChecked) {
                ctv4Text = ctv4!!.text.toString()
                selectedTimes[3] = rg4!!.checkedRadioButtonId
                radioButton = findViewById(selectedTimes[3])
                radio4Text = radioButton.text.toString()
            }

            // is there a conflict
            if (radioCheck(selectedTimes)) {

                // intent to next screen
                val nextScreen2 = Intent(this@ChooseClass, Summary::class.java).apply {
                    putExtra("firstName", firstName)
                    putExtra("lastName", lastName)
                    putExtra("phone", phone)
                    putExtra("birthday", birthDate)
                    putExtra("isDegreeCert", isDegreeCert)
                    putExtra("class1", ctv1Text)
                    putExtra("selected1", radio1Text)
                    putExtra("class2", ctv2Text)
                    putExtra("selected2", radio2Text)
                    putExtra("class3", ctv3Text)
                    putExtra("selected3", radio3Text)
                    putExtra("class4", ctv4Text)
                    putExtra("selected4", radio4Text)
                    putExtra("degreeCert", degreeCertification)
                }

                // start activity
                startActivity(nextScreen2)

            }
            else {
                Toast.makeText(applicationContext,"Time slot conflict!", Toast.LENGTH_LONG).show()
            }
        }

        val radioButtons = arrayOf(rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8)

        // set errors to null if you check on a button
        for (radioButton in radioButtons) {
            radioButton!!.setOnCheckedChangeListener { _, _ ->
                rb1!!.error = null
                rb2!!.error = null
                rb3!!.error = null
                rb4!!.error = null
                rb5!!.error = null
                rb6!!.error = null
                rb7!!.error = null
                rb8!!.error = null
            }
        }

        ctv1!!.setOnClickListener {
            if(ctv1!!.isChecked) {
                enableDisable(ctv1, rb1, rb2, Color.WHITE, false)
            }
            else {
                enableDisable(ctv1, rb1, rb2, Color.WHITE, true)
                rb1!!.isChecked = true
            }
        }

        ctv2!!.setOnClickListener {
            if(ctv2!!.isChecked) {
                enableDisable(ctv2, rb3, rb4, Color.WHITE, false)
            }
            else {
                enableDisable(ctv2, rb3, rb4, Color.WHITE, true)
                rb3!!.isChecked = true
            }
        }

        ctv3!!.setOnClickListener {
            if(ctv3!!.isChecked) {
                enableDisable(ctv3, rb5, rb6, Color.WHITE, false)
            }
            else {
                enableDisable(ctv3, rb5, rb6, Color.WHITE, true)
                rb5!!.isChecked = true
            }
        }

        ctv4!!.setOnClickListener {
            if(ctv4!!.isChecked) {
                enableDisable(ctv4, rb7, rb8, Color.WHITE, false)
            }
            else {
                enableDisable(ctv4, rb7, rb8, Color.WHITE, true)
                rb7!!.isChecked = true
            }
        }


    }

    private fun enableDisable(ctv: CheckedTextView?, rb1: RadioButton?, rb2: RadioButton?, bgColor: Int?, state: Boolean?) {
        ctv!!.isChecked = state!!
        ctv.setBackgroundColor(bgColor!!)
        rb1!!.isEnabled = state
        rb2!!.isEnabled = state

        rb2!!.isChecked = state

        if (!state) {
            rb1.isChecked = state
            rb2.isChecked = state
        }

    }

    private fun radioCheck(selectedTimes: Array<Int>) : Boolean {

        if (selectedTimes[0] == R.id.rb2 && selectedTimes[3] == R.id.rb7) {
            rb2!!.error = "Time slot conflict"
            rb7!!.error = "Time slot conflict"
            return false
        }

        if (selectedTimes[0] == R.id.rb1 && selectedTimes[1] == R.id.rb3) {
            rb1!!.error = "Time slot conflict"
            rb3!!.error = "Time slot conflict"
            return false
        }

        if (selectedTimes[2] == R.id.rb5 && selectedTimes[3] == R.id.rb8) {
            rb5!!.error = "Time slot conflict"
            rb8!!.error = "Time slot conflict"
            return false
        }

        return true
    }
}
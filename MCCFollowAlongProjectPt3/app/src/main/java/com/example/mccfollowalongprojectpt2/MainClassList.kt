package com.example.mccfollowalongprojectpt2


//import android.widget.*
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainClassList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)


        val firstName: EditText = findViewById(R.id.firstName)
        val lastName: EditText = findViewById(R.id.lastName)
        val phone: EditText = findViewById(R.id.phone)

        val month: Spinner = findViewById(R.id.monthSpinner)
        val day: EditText = findViewById(R.id.dayText)
        val year: EditText = findViewById(R.id.yearText)

        val switchCertDegree: SwitchCompat = findViewById(R.id.certDegreeSwitch)

        val certificateList: Spinner = findViewById(R.id.certificateSpinner)
        val certificateText: TextView = findViewById(R.id.certificatesText)

        val majorList: Spinner = findViewById(R.id.majorSpinner)
        val majorsText: TextView = findViewById(R.id.majorsText)

        val nextButton: Button = findViewById(R.id.nextButton)

        firstName.requestFocus()

        // hide certificates when screen starts
        majorList.visibility = View.VISIBLE
        majorsText.visibility = View.VISIBLE
        certificateList.visibility = View.GONE
        certificateText.visibility = View.GONE

        switchCertDegree.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                majorList.visibility = View.VISIBLE
                majorsText.visibility = View.VISIBLE
                certificateList.visibility = View.GONE
                certificateText.visibility = View.GONE
            }
            else {
                majorList.visibility = View.GONE
                majorsText.visibility = View.GONE
                certificateList.visibility = View.VISIBLE
                certificateText.visibility = View.VISIBLE
            }
        }

        nextButton.setOnClickListener {
            // check data
            if (isDataValid()) {
                var dateOfBirth = ""
                dateOfBirth = month.selectedItem.toString() + "/" + day.text.toString() + "/" + year.text.toString()

                val nextScreen = Intent(this, ChooseClass::class.java)
                nextScreen.putExtra("firstName", firstName.text.toString())
                nextScreen.putExtra("lastName", lastName.text.toString())
                nextScreen.putExtra("phone", phone.text.toString())

                nextScreen.putExtra("birthday", dateOfBirth)

                if(switchCertDegree.isChecked) {
                    // chose degree
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", majorList.selectedItem.toString())
                }
                else {
                    // chose certificate
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", certificateList.selectedItem.toString())

                }

                println("GO TO NEW SCreen")
                startActivity(nextScreen)
            }
        }

    }

    private fun isDataValid() : Boolean {

        val firstName: EditText = findViewById(R.id.firstName)
        val lastName: EditText = findViewById(R.id.lastName)
        val phone: EditText = findViewById(R.id.phone)
        val day: EditText = findViewById(R.id.dayText)
        val year: EditText = findViewById(R.id.yearText)

        when {
            firstName.text.toString().isEmpty() -> {
                firstName.error = "Invalid first name."
                firstName.requestFocus()
                return false
            }
            lastName.text.toString().isEmpty() -> {
                lastName.error = "Invalid last name."
                lastName.requestFocus()
                return false
            }
            phone.text.toString().isEmpty() -> {
                phone.error = "Invalid phone number."
                phone.requestFocus()
                return false
            }
            day.text.toString().isEmpty() -> {
                day.error = "Invalid date selection."
                day.requestFocus()
                return false
            }
            year.text.toString().isEmpty() -> {
                year.error = "Invalid year selection."
                year.requestFocus()
                return false
            }
            else -> return true
        }

    }

}


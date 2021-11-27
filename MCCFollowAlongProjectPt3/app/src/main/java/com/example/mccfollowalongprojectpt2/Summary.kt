package com.example.mccfollowalongprojectpt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.StringBuilder

class Summary : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras

        if (extras != null) {
            // get data from previous screen
            var firstName = extras.getString("firstName")
            var lastName = extras.getString("lastName")
            var phone = extras.getString("phone")
            var birthDate = extras.getString("birthday")
            var isDegreeCert = extras.getString("isDegreeCert")
            var degreeCert = extras.getString("degreeCert")
            var class1 = extras.getString("class1")
            var selected1 = extras.getString("selected1")
            var class2 = extras.getString("class2")
            var selected2 = extras.getString("selected2")
            var class3 = extras.getString("class3")
            var selected3 = extras.getString("selected3")
            var class4 = extras.getString("class4")
            var selected4 = extras.getString("selected4")

            val textStudent: TextView = findViewById(R.id.textStudent)
            val textPhone: TextView = findViewById(R.id.textPhone)
            val textBirthDate: TextView = findViewById(R.id.textBirthday)
            val textDegreePlan: TextView = findViewById(R.id.textDegree)
            val textMajor: TextView = findViewById(R.id.textMajor)
            val textClassSchedule: TextView = findViewById(R.id.textClassSchedule)

            textStudent.text = "$firstName $lastName"
            textPhone.text = phone
            textBirthDate.text = birthDate
            textDegreePlan.text = isDegreeCert
            textMajor.text = degreeCert

            val classSchedule = StringBuilder(250)
            if (class1 != "") {
                classSchedule.append(class1 + "\n" + selected1 + "\n\n")
            }
            if (class2 != "") {
                classSchedule.append(class2 + "\n" + selected2 + "\n\n")
            }
            if (class3 != "") {
                classSchedule.append(class3 + "\n" + selected3 + "\n\n")
            }
            if (class4 != "") {
                classSchedule.append(class4 + "\n" + selected4 + "\n\n")
            }

            textClassSchedule.text = classSchedule
        }



    }
}
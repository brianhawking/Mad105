/**
* Class - mainActivity
* @author - Brian Veitch
* date - 10/8
* @param
* userChoice - get input from user
* @description
* Get customer information (residential or commercial) for a landscaping quote
*
* mods
* BV
*/

package com.example.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonProfile = findViewById<Button>(R.id.idButtonViewProfile) as Button

        // button to transition to MainActivity2
        buttonProfile.setOnClickListener{
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
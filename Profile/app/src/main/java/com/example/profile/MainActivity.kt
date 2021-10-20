/**
* Class - mainActivity
* @author - Brian Veitch
* date - 10/16
* @param
* buttonProfile
* @description
* Display name, profile image, and view profile button

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
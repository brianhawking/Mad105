package com.example.passingdataexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var button: Button = findViewById(R.id.button2)

        button.setOnClickListener {
            val data = Intent().apply {
                val array = arrayOf("1","2","3")
                putExtra("name","Brian")
                putExtra("number","5")
                putExtra("array",array)
            }
            setResult(Activity.RESULT_OK, data)

            finish()
        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()

    }
}
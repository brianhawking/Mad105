package com.example.passingdataexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult? ->
        if((result?.resultCode == Activity.RESULT_OK)){

            val intent = result.data
            val array = intent?.extras?.getStringArray("array")
            if (array != null) {
                array.forEach {
                    println(it)
                }
            }
            textView.text = "We got result"
        } else {
            textView.text = "Failed to get result"
        }
    }
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("number","9")
            resultContract.launch(intent)
        }

    }
}
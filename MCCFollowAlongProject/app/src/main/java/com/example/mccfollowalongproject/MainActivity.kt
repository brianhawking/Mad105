package com.example.mccfollowalongproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

enum class LoginSuccess
    constructor(val intVal: Int) {
        success(0),
        login(1),
        password(2)
    }



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginText: TextView = findViewById(R.id.loginText)
        val passwordText: TextView = findViewById(R.id.passwordText)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            when(checkLogin(loginText.text.toString(),passwordText.text.toString() )) {
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    loginText.requestFocus()
                    loginText.text = ""
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_LONG).show()
                    passwordText.requestFocus()
                    passwordText.text = ""
                }
                else -> {
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun checkLogin(loginText: String, passwordText: String) : LoginSuccess {
        val holdLogin = "Brian"
        val holdPassword = "password"

        return when {
            holdLogin != loginText -> {
                LoginSuccess.login
            }
            holdPassword != passwordText -> {
                LoginSuccess.password
            }
            else -> {
                LoginSuccess.success
            }
        }
    }


}
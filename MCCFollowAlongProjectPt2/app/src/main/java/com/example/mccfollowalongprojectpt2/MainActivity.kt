package com.example.mccfollowalongprojectpt2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

enum class LoginSuccess {
    Success,
    Login,
    Password
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
                LoginSuccess.Login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    loginText.requestFocus()
                    loginText.text = ""
                }
                LoginSuccess.Password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_LONG).show()
                    passwordText.requestFocus()
                    passwordText.text = ""
                }
                else -> {
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                    val intent = Intent(this,MainClassList::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkLogin(loginText: String, passwordText: String) : LoginSuccess {
        val holdLogin = "Brian"
        val holdPassword = "password"

        return when {
            holdLogin != loginText -> {
                LoginSuccess.Login
            }
            holdPassword != passwordText -> {
                LoginSuccess.Password
            }
            else -> {
                LoginSuccess.Success
            }
        }
    }


}
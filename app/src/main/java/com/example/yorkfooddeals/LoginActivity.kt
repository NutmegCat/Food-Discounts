package com.example.yorkfooddeals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// LoginActivity.kt
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etYorkID = findViewById<EditText>(R.id.etAdminUsername)
        val etPassword = findViewById<EditText>(R.id.etAdminPassword)
        val btnLogin = findViewById<Button>(R.id.btnAdminLogin)
        val tvAdminLogin = findViewById<TextView>(R.id.tvAdminLogin)

        btnLogin.setOnClickListener {
            val username = etYorkID.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username == "york123" && password == "testPass") { // this is a fake user, no one get excited
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        tvAdminLogin.setOnClickListener {
            // Go to AdminLoginActivity
            val intent = Intent(this, AdminLoginActivity::class.java)
            startActivity(intent)
        }
    }
}

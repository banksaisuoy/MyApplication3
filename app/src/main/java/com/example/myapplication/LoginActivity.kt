package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (username.isNotBlank() && password.isNotBlank()) {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                if (username.isBlank()) {
                    binding.usernameInputLayout.error = "Username required"
                } else {
                    binding.usernameInputLayout.error = null
                }
                if (password.isBlank()) {
                    binding.passwordInputLayout.error = "Password required"
                } else {
                    binding.passwordInputLayout.error = null
                }
            }
        }
    }
}

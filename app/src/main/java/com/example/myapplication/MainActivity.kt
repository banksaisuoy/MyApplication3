package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val refreshButton: Button = findViewById(R.id.refreshButton)
        refreshButton.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.refresh_success), Snackbar.LENGTH_SHORT).show()
        }
    }
}

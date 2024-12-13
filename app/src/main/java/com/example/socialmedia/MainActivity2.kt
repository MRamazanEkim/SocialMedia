package com.example.socialmedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2) // Set layout for MainActivity2

        // Button to navigate to Page2
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            // Navigate to Page2
            val intent = Intent(this, Page2::class.java)
            startActivity(intent)
        }

        // Button to navigate back to MainActivity
        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            // Finish MainActivity2 to return to MainActivity
            finish()
        }
    }
}

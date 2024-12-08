package com.example.socialmedia

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page3)

        val tvBirthday = findViewById<TextView>(R.id.tvBirthday)

        tvBirthday.setOnClickListener {
            // Get the current date
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Show DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Update TextView with the selected date
                    val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    tvBirthday.text = formattedDate
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        // Initialize with the selected date
        datePicker.init(2000, 0, 1) { _, year, month, day ->
            val formattedDate = "$day/${month + 1}/$year"
            tvBirthday.text = "Selected Birthday: $formattedDate"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
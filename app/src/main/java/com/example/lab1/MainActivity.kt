package com.example.symbolchecker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab1)

        val inputText = findViewById<TextInputEditText>(R.id.input_text)
        val checkButton = findViewById<Button>(R.id.button_check)
        val resultText = findViewById<TextView>(R.id.result_text)

        checkButton.setOnClickListener {
            val input = inputText.text.toString().trim()

            if (input.length != 1) {
                Toast.makeText(this, "Пожалуйста, введите один символ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val char = input[0]

            if (char.isUpperCase()) {
                when (char) {
                    'L', 'M', 'K', 'D' -> resultText.text = "Это согласные буквы"
                    else -> resultText.text = "Возможно, это гласные буквы"
                }
            } else {
                Toast.makeText(this, "Введите латинскую заглавную букву", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

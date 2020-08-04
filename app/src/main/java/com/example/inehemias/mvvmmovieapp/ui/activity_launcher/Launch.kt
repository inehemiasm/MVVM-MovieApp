package com.example.inehemias.mvvmmovieapp.ui.activity_launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import com.example.inehemias.mvvmmovieapp.R
import com.example.inehemias.mvvmmovieapp.ui.popular_movie.MainActivity
import com.google.android.material.textfield.TextInputEditText


class Launch : AppCompatActivity() {
    private lateinit var textInput: TextInputEditText
    private lateinit var button: Button
    private val  correctText = "Welcome to my page"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        textInput =  findViewById(R.id.inputText)
        button = findViewById(R.id.activityLaunchButton)

        textInput.doOnTextChanged { text, _, _, _ ->
            if (text!!.contains(correctText)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
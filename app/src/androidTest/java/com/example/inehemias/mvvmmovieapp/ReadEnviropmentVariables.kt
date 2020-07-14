package com.example.inehemias.mvvmmovieapp

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner

class ReadEnviropmentVariables: AndroidJUnitRunner() {

    companion object {
        var variable1 = ""
        var variable2 = ""
    }

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        variable1 = arguments?.getString("variable1") ?: "Nothing was passed"
        variable2 = arguments?.getString("variable2") ?: "Nothing was passed"
    }
}
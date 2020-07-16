package com.example.inehemias.mvvmmovieapp.testutils

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner

class BaseTestClass : AndroidJUnitRunner() {

    companion object {
        lateinit var locale: String
        lateinit var testTag: String
    }

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        locale = arguments?.getString("locale") ?: "en_us"
        testTag = arguments?.getString("suite") ?: "Regression"
    }
}
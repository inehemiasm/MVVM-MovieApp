package com.example.inehemias.mvvmmovieapp.testutils

import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import java.io.IOException
import java.util.Properties
import timber.log.Timber

object loadTestData {

    fun getLocalizedProperty(propKey: String): String {
        val localizedFile = TestSetup.locale + "_file.properties"
        val props = Properties()
        try {
            getInstrumentation().context.resources
                .assets.open(localizedFile).use { inputStream -> props.load(inputStream) }
        } catch (ex: IOException) {
            Timber.e(ex)
        }
        val secret = props.getProperty(propKey)
        return secret ?: ""
    }
}

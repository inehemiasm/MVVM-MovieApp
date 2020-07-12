package com.example.inehemias.mvvmmovieapp

import android.os.Build
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.inehemias.mvvmmovieapp", appContext.packageName)
        Log.d("Testing", "useAppContext: ${System.getenv()}   ${System.getProperties()}")
        Log.d("Testing", "useAppContext: ${System.getenv()}   ${System.getProperties()}")

        val fields = Build.MANUFACTURER
        Log.d("Testing", "useAppContext: $fields ")
//        fields.forEach {   Log.d("Testing", "useAppContext: ${it.name} ")}
    }
}

package com.example.inehemias.mvvmmovieapp.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import com.example.inehemias.mvvmmovieapp.testutils.AndroidTags
import com.example.inehemias.mvvmmovieapp.testutils.TestSetup
import com.example.inehemias.mvvmmovieapp.testutils.TestTags
import com.example.inehemias.mvvmmovieapp.ui.popular_movie.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import timber.log.Timber

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidTags::class)
class DemoTest {

    private val locale by lazy { TestSetup.locale }

    @Test
    @TestTags(runTags = ["Regression"])
    fun verifyThisTestWillRunForUS() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.inehemias.mvvmmovieapp", appContext.packageName)
        assertEquals("en_us", locale)
    }

    @Test
    @TestTags(runTags = ["SMOKE_BR"])
    fun verifyThisTestWillRunForBrazil() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.inehemias.mvvmmovieapp", appContext.packageName)
        assertEquals("pt_br", locale)
    }

    @Test
    @TestTags(runTags = ["SMOKE_DE"])
    fun verifyThisTestWillRunForDE() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.inehemias.mvvmmovieapp", appContext.packageName)
        assertEquals("de_de", locale)
    }
}

package com.example.inehemias.mvvmmovieapp.tests

import androidx.test.core.app.ActivityScenario
import com.example.inehemias.mvvmmovieapp.testutils.AndroidTags
import com.example.inehemias.mvvmmovieapp.testutils.TestSetup
import com.example.inehemias.mvvmmovieapp.testutils.TestTags
import com.example.inehemias.mvvmmovieapp.testutils.loadTestData
import com.example.inehemias.mvvmmovieapp.ui.popular_movie.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import timber.log.Timber

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidTags::class)
class DemoTest {

    private val locale by lazy { TestSetup.locale }

    @Before
    fun initializeVariables() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    @TestTags(runTags = ["Regression", "SMOKE_BR", "SMOKE_DE"])
    fun verifyThisTestWillRunForUS() {
        Timber.e("Running ${TestSetup.tags[0]} tests for $locale ")
        assertEquals("Welcome to my app", loadTestData.getLocalizedProperty("welcome"))
    }

    @Test
    @TestTags(runTags = ["SMOKE_BR"])
    fun verifyThisTestWillRunForBrazil() {
        Timber.e("Running ${TestSetup.tags[0]} tests for $locale ")
        assertEquals("Bem vindo ao meu aplicativo", loadTestData.getLocalizedProperty("welcome"))
    }

    @Test
    @TestTags(runTags = ["SMOKE_DE", "SMOKE_BR"])
    fun verifyThisTestWillRunForDE() {
        Timber.e("Running ${TestSetup.tags[0]} tests for $locale ")
        assertEquals("Welkom bij mijn app", loadTestData.getLocalizedProperty("welcome"))
    }
}

package com.example.inehemias.mvvmmovieapp.testutils


/**
 * This class is used to configure your tests to run. This configuration will be used for all tests to run.
 */
object TestSetup {
    // keep this in alphabetical order
    val tags = arrayOf(
        BaseTestClass.testTag
        // "Smoke_BR"
        // "Smoke_DE",
        // "Regression"
    )

    val locale = BaseTestClass.locale // en_us, de_de, pt_br
}
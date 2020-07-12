package com.example.inehemias.mvvmmovieapp.utils

import android.content.Context
import android.util.Log
import java.util.*

object loadProperties {

    fun getProperties(context: Context, key: String): String {
        val props = Properties()
        val assetManager = context.assets
        val inputStream = assetManager.open("keys.properties")
        props.load(inputStream)
        return props.getProperty(key)
    }

    fun printSystemVariableFromJenkings() {
        val testString = System.getenv("locale")
        val urlString = System.getenv("testenv")
        println(testString)
        println(urlString)
        Log.d("Utils", "printSystemVariableFromJenkings: $testString $urlString ")
    }
}
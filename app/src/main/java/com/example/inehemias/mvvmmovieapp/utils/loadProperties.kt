package com.example.inehemias.mvvmmovieapp.utils

import android.content.Context
import java.util.Properties

object loadProperties {
    var name = " "

    fun getProperties(context: Context, key: String): String {
        val props = Properties()
        val assetManager = context.assets
        val inputStream = assetManager.open("keys.properties")
        props.load(inputStream)
        return props.getProperty(key)
    }
}

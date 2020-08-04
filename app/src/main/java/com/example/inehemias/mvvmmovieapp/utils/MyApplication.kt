package com.example.inehemias.mvvmmovieapp.utils

import android.app.Application
import com.example.inehemias.mvvmmovieapp.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}

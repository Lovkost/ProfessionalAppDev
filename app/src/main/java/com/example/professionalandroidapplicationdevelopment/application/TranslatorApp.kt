package com.example.professionalandroidapplicationdevelopment.application

import android.app.Application
import com.example.professionalandroidapplicationdevelopment.di.application
import com.example.professionalandroidapplicationdevelopment.di.historyScreen
import com.example.professionalandroidapplicationdevelopment.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
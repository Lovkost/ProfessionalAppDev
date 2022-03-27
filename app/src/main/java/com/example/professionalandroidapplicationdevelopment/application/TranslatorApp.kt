package com.example.professionalandroidapplicationdevelopment.application

import android.app.AppComponentFactory
import android.app.Application
import com.example.professionalandroidapplicationdevelopment.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TranslatorApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
    DaggerAppComponent.builder()

    }
}
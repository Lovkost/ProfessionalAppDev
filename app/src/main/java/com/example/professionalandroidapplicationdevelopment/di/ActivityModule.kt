package com.example.professionalandroidapplicationdevelopment.di

import com.example.professionalandroidapplicationdevelopment.view.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
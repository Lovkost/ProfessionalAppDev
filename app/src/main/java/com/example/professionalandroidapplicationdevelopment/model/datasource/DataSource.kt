package com.example.professionalandroidapplicationdevelopment.model.datasource

import android.database.Observable

interface DataSource<T> {

    suspend fun getData(word: String): T
}
package com.example.professionalandroidapplicationdevelopment.model.datasource

import com.example.professionalandroidapplicationdevelopment.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}
package com.example.professionalandroidapplicationdevelopment.model.repository

import com.example.professionalandroidapplicationdevelopment.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
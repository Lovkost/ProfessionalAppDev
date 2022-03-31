package com.example.professionalandroidapplicationdevelopment.viewmodel


interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
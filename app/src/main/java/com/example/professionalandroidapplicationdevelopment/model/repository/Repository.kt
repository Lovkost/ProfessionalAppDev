package com.example.professionalandroidapplicationdevelopment.model.repository


interface Repository<T> {

    suspend fun getData(word: String): T
}
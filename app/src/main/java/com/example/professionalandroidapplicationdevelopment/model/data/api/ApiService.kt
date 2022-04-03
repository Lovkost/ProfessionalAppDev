package com.example.professionalandroidapplicationdevelopment.model.data.api

import android.database.Observable
import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModel>>
}
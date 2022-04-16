package com.example.repository.api

import androidx.room.Query
import com.google.firebase.inject.Deferred
import geekbrains.ru.model.data.dto.SearchResultDto

interface ApiService {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String):
            Deferred<List<SearchResultDto>>
}

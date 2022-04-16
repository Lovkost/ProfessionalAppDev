package com.example.repository

import com.example.model.data.userdata.DataModel
import geekbrains.ru.model.data.dto.SearchResultDto

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}
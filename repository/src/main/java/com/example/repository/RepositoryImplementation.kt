package com.example.repository

import com.example.model.data.DataModel

class RepositoryImplementation(private val dataSource: DataSource<List<com.example.model.data.DataModel>>) :
    Repository<List<com.example.model.data.DataModel>> {

    override suspend fun getData(word: String): List<com.example.model.data.DataModel> {
        return dataSource.getData(word)
    }
}
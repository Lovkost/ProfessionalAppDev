package com.example.professionalandroidapplicationdevelopment.model.repository

import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
package com.example.repository

import com.example.model.data.userdata.DataModel

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: com.example.model.data.AppState) {
        dataSource.saveToDB(appState)
    }
}
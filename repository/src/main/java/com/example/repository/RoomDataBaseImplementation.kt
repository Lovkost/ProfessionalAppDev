package com.example.repository

import com.example.model.data.userdata.DataModel
import com.example.repository.room.HistoryDao
import com.example.professionalandroidapplicationdevelopment.utils.convertDataModelSuccessToEntity
import com.example.professionalandroidapplicationdevelopment.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: com.example.model.data.AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
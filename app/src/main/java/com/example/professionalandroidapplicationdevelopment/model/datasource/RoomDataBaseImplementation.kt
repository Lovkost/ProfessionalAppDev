package com.example.professionalandroidapplicationdevelopment.model.datasource

import com.example.professionalandroidapplicationdevelopment.model.data.AppState
import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.room.HistoryDao
import com.example.professionalandroidapplicationdevelopment.utils.convertDataModelSuccessToEntity
import com.example.professionalandroidapplicationdevelopment.utils.mapHistoryEntityToSearchResult

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
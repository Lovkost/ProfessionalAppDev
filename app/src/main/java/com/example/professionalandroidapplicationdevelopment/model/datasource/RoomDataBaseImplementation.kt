package com.example.professionalandroidapplicationdevelopment.model.datasource

import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")
    }
}
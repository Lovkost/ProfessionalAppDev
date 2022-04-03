package com.example.professionalandroidapplicationdevelopment.view.main

import com.example.professionalandroidapplicationdevelopment.model.data.AppState
import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.model.repository.Repository
import com.example.professionalandroidapplicationdevelopment.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
package com.example.professionalandroidapplicationdevelopment.view.history

import com.example.model.data.AppState
import com.example.model.data.DataModel
import com.example.repository.Repository
import com.example.repository.RepositoryLocal
import com.example.core.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: com.example.repository.Repository<List<com.example.model.data.DataModel>>,
    private val repositoryLocal: com.example.repository.RepositoryLocal<List<com.example.model.data.DataModel>>
) : com.example.core.viewmodel.Interactor<com.example.model.data.AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): com.example.model.data.AppState {
        return com.example.model.data.AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
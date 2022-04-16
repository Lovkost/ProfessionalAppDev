package com.example.professionalandroidapplicationdevelopment.view.main

import com.example.core.viewmodel.Interactor
import com.example.model.data.AppState
import com.example.model.data.userdata.DataModel
import com.example.professionalandroidapplicationdevelopment.utils.mapSearchResultToResult
import com.example.repository.Repository
import com.example.repository.RepositoryLocal
import geekbrains.ru.model.data.dto.SearchResultDto

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
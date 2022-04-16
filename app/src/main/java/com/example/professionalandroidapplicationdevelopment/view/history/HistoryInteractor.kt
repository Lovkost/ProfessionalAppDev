package com.example.professionalandroidapplicationdevelopment.view.history

import com.example.core.viewmodel.Interactor
import com.example.model.data.AppState
import com.example.professionalandroidapplicationdevelopment.utils.mapSearchResultToResult
import com.example.repository.Repository
import com.example.repository.RepositoryLocal
import geekbrains.ru.model.data.dto.SearchResultDto

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
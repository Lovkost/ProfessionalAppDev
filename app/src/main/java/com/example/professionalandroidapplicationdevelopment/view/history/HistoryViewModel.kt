package com.example.professionalandroidapplicationdevelopment.view.history

import androidx.lifecycle.LiveData
import com.example.model.data.AppState
import com.example.professionalandroidapplicationdevelopment.utils.parseLocalSearchResults
import com.example.core.viewmodel.BaseViewModel

class HistoryViewModel(private val interactor: HistoryInteractor) :
    com.example.core.viewmodel.BaseViewModel<com.example.model.data.AppState>() {

    private val liveDataForViewToObserve: LiveData<com.example.model.data.AppState> = _mutableLiveData

    fun subscribe(): LiveData<com.example.model.data.AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = com.example.model.data.AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(parseLocalSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(com.example.model.data.AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = com.example.model.data.AppState.Success(null)//Set View to original state in onStop
        super.onCleared()
    }
}

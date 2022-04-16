package com.example.professionalandroidapplicationdevelopment.view.main

import androidx.lifecycle.LiveData
import com.example.model.data.AppState
import com.example.professionalandroidapplicationdevelopment.utils.parseOnlineSearchResults
import com.example.core.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(private val interactor: MainInteractor) :
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

    //Doesn't have to use withContext for Retrofit call if you use .addCallAdapterFactory(CoroutineCallAdapterFactory()). The same goes for Room
    private suspend fun startInteractor(word: String, isOnline: Boolean) = withContext(Dispatchers.IO) {
        _mutableLiveData.postValue(parseOnlineSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(com.example.model.data.AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = com.example.model.data.AppState.Success(null)
        super.onCleared()
    }
}

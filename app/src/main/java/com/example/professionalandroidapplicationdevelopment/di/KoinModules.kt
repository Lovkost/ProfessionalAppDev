package com.example.professionalandroidapplicationdevelopment.di

import androidx.room.Room
import com.example.model.data.DataModel
import com.example.repository.RetrofitImplementation
import com.example.repository.RoomDataBaseImplementation
import com.example.repository.Repository
import com.example.repository.RepositoryImplementation
import com.example.repository.RepositoryImplementationLocal
import com.example.repository.RepositoryLocal
import com.example.repository.room.HistoryDataBase
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryInteractor
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryViewModel
import com.example.professionalandroidapplicationdevelopment.view.main.MainInteractor
import com.example.professionalandroidapplicationdevelopment.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<com.example.repository.Repository<List<com.example.model.data.DataModel>>> {
        com.example.repository.RepositoryImplementation(
            com.example.repository.RetrofitImplementation()
        )
    }
    single<com.example.repository.RepositoryLocal<List<com.example.model.data.DataModel>>> {
        com.example.repository.RepositoryImplementationLocal(
            com.example.repository.RoomDataBaseImplementation(
                get()
            )
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
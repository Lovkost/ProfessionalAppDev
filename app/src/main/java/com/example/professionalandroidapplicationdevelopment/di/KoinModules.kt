package com.example.professionalandroidapplicationdevelopment.di

import androidx.room.Room
import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.model.datasource.RetrofitImplementation
import com.example.professionalandroidapplicationdevelopment.model.datasource.RoomDataBaseImplementation
import com.example.professionalandroidapplicationdevelopment.model.repository.Repository
import com.example.professionalandroidapplicationdevelopment.model.repository.RepositoryImplementation
import com.example.professionalandroidapplicationdevelopment.model.repository.RepositoryImplementationLocal
import com.example.professionalandroidapplicationdevelopment.model.repository.RepositoryLocal
import com.example.professionalandroidapplicationdevelopment.room.HistoryDataBase
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryInteractor
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryViewModel
import com.example.professionalandroidapplicationdevelopment.view.main.MainInteractor
import com.example.professionalandroidapplicationdevelopment.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
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
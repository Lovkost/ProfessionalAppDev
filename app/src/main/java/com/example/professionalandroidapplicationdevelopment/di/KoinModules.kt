package com.example.professionalandroidapplicationdevelopment.di

import androidx.room.Room
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryActivity
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryInteractor
import com.example.professionalandroidapplicationdevelopment.view.history.HistoryViewModel
import com.example.professionalandroidapplicationdevelopment.view.main.MainActivity
import com.example.professionalandroidapplicationdevelopment.view.main.MainInteractor
import com.example.professionalandroidapplicationdevelopment.view.main.MainViewModel
import com.example.repository.*
import com.example.repository.room.HistoryDataBase
import geekbrains.ru.model.data.dto.SearchResultDto
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<geekbrains.ru.model.room.HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
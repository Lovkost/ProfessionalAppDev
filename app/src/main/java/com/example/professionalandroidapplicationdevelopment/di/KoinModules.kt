package com.example.professionalandroidapplicationdevelopment.di

import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.model.datasource.RetrofitImplementation
import com.example.professionalandroidapplicationdevelopment.model.datasource.RoomDataBaseImplementation
import com.example.professionalandroidapplicationdevelopment.model.repository.Repository
import com.example.professionalandroidapplicationdevelopment.model.repository.RepositoryImplementation
import com.example.professionalandroidapplicationdevelopment.view.main.MainInteractor
import com.example.professionalandroidapplicationdevelopment.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
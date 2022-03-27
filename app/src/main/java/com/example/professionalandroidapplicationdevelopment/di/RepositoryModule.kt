package com.example.professionalandroidapplicationdevelopment.di

import com.example.professionalandroidapplicationdevelopment.model.data.DataModel
import com.example.professionalandroidapplicationdevelopment.model.datasource.DataSource
import com.example.professionalandroidapplicationdevelopment.model.datasource.RetrofitImplementation
import com.example.professionalandroidapplicationdevelopment.model.datasource.RoomDataBaseImplementation
import com.example.professionalandroidapplicationdevelopment.model.repository.Repository
import com.example.professionalandroidapplicationdevelopment.model.repository.RepositoryImplementation
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImplementation()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImplementation()
}
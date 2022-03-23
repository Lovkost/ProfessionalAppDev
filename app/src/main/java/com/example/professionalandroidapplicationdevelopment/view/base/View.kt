package com.example.professionalandroidapplicationdevelopment.view.base

import com.example.professionalandroidapplicationdevelopment.model.data.AppState

interface View {

    fun renderData(appState: AppState)
}
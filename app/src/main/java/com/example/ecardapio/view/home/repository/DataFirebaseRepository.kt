package com.example.ecardapio.view.home.repository

import com.example.ecardapio.view.home.util.UiState

interface DataFirebaseRepository {
    suspend fun getNameBusiness(result : (UiState<String>) -> Unit)

}
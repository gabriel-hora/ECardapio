package com.example.ecardapio.view.home.repository

interface DataFirebaseRepository {
    suspend fun getNameBusiness() : String

}
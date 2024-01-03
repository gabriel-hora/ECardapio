package com.example.ecardapio.view.home.repository

import android.util.Log
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await

class DataFirebaseRepositoryImpl(
    private val database: DatabaseReference
) : DataFirebaseRepository {
    override suspend fun getNameBusiness(): String {
        val result = database.child("users").get().addOnCompleteListener {
            // TODO: Resolver TASK NÃO FOI COMPLETADA
        }

        return "FUNCIONOU"
    }
}
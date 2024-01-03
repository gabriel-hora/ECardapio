package com.example.ecardapio.view.home.repository

import com.example.ecardapio.view.home.util.UiState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class DataFirebaseRepositoryImpl(
    private val database: DatabaseReference,
    private val auth: FirebaseAuth
) : DataFirebaseRepository {
    override suspend fun getNameBusiness(result: (UiState<String>) -> Unit) {

        database
            .child("users").child(auth.uid!!).child("personal").child("name").get()
            .addOnCompleteListener {
                result.invoke(UiState.Success(it.result.value.toString()))
            }.addOnFailureListener {
                result.invoke(UiState.Failure(it.message))
            }
    }
}
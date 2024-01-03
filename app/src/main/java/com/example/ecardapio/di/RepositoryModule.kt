package com.example.ecardapio.di

import com.example.ecardapio.view.home.repository.DataFirebaseRepository
import com.example.ecardapio.view.home.repository.DataFirebaseRepositoryImpl
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataFirebaseRepository(
        database : DatabaseReference
    ) : DataFirebaseRepository {
        return DataFirebaseRepositoryImpl(database)
    }

}
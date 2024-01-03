package com.example.ecardapio.view.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecardapio.view.home.repository.DataFirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataHomeViewModel @Inject constructor(
    private val repository: DataFirebaseRepository
) : ViewModel() {

    val dataPersonal = MutableLiveData<String>()
    fun getData() {
        viewModelScope.launch {
            getDataFirebase()
        }
    }
    private suspend fun getDataFirebase() {
        dataPersonal.value = repository.getNameBusiness()
    }
}
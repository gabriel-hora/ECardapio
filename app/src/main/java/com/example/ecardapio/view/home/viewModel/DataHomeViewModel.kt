package com.example.ecardapio.view.home.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecardapio.view.home.repository.DataFirebaseRepository
import com.example.ecardapio.view.home.util.ScreenState
import com.example.ecardapio.view.home.util.UiState
import com.example.ecardapio.view.home.util.UiStateComposable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataHomeViewModel @Inject constructor(
    private val repository: DataFirebaseRepository
) : ViewModel() {

    private val _dataPersonal = MutableLiveData<UiState<String>>()
    val dataPersonal: LiveData<UiState<String>>
        get() = _dataPersonal


    val screenState = mutableStateOf(UiStateComposable())

    fun getData() {
        viewModelScope.launch {
            getDataFirebase()
        }
    }

    private suspend fun getDataFirebase() {
        _dataPersonal.value = UiState.Loading
        repository.getNameBusiness {
            _dataPersonal.value = it
            screenState.value = screenState.value.copy(ScreenState.SUCCESS)
        }
    }
}
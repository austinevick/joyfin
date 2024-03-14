package com.example.joyfin.screens

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joyfin.api.ApiClient
import com.example.joyfin.model.UserData
import com.example.joyfin.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class AppViewModel : ViewModel() {
    val showAmount = mutableStateOf(false)
    private val _dataFlow = MutableStateFlow(UiState())
    val userData = _dataFlow.asStateFlow()

    fun getUserData() {
        viewModelScope.launch {
            try {
                val user = ApiClient().apiService.userData()
                if (user.body() != null) {
                    _dataFlow.value = _dataFlow.value.copy(
                        data = user.body()!!, error = null
                    )
                    Log.d("AppViewModel Response", _dataFlow.value.toString())
                }
            } catch (e: IOException) {
                Log.d("AppViewModel", e.message!!)
                _dataFlow.value = _dataFlow.value.copy(
                    data = null, error = "Unable to load page"
                )
            }
        }
    }
}

data class UiState(
    val data: UserData? = null,
    val error: String? = null
)
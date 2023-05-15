package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    val usernameMap = _username
        .map { it }
        .flowOn(Dispatchers.Main)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            ""
        )

    fun onSearchChange(value: String) {
        _username.update { value }
    }
}
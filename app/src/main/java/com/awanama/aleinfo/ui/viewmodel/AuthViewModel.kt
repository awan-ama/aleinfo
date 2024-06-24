package com.awanama.aleinfo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.model.User
import com.awanama.aleinfo.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val user = userRepository.getUser(username, password)
            _isLoggedIn.value = user != null
        }
    }

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            val user = User(username = username, email = email, password = password)
            userRepository.insertUser(user)
            _isLoggedIn.value = true
        }
    }
}

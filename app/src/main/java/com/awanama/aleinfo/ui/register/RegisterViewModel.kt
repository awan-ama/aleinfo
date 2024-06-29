package com.awanama.aleinfo.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.entity.User
import com.awanama.aleinfo.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _isRegistered = MutableStateFlow(false)
    val isRegistered: StateFlow<Boolean> = _isRegistered

    private val _registerError = MutableStateFlow<String?>(null)
    val registerError: StateFlow<String?> = _registerError

    fun register(username: String, email: String, password: String) {
        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            _registerError.value = "All fields are required"
            _isRegistered.value = false
            return
        }

        viewModelScope.launch {
            val existingUser = userRepository.getUserByUsername(username)
            if (existingUser != null) {
                _registerError.value = "User already exists"
                _isRegistered.value = false
            } else {
                val user = User(username = username, email = email, password = password)
                userRepository.insertUser(user)
                _isRegistered.value = true
                _registerError.value = null
            }
        }
    }
}

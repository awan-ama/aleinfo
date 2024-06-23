//package com.awanama.aleinfo.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.awanama.aleinfo.data.entity.User
//import com.awanama.aleinfo.data.repository.UserRepository
//import kotlinx.coroutines.launch
//
//class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {
//    var registrationSuccessful: Boolean = false
//    var errorMessage: String? = null
//
//    fun register(email: String, username: String, password: String) {
//        viewModelScope.launch {
//            val existingUser = userRepository.getUser(email, password)
//            if (existingUser == null) {
//                userRepository.insertUser(User(email, username, password))
//                registrationSuccessful = true
//            } else {
//                registrationSuccessful = false
//                errorMessage = "Email already exists"
//            }
//        }
//    }
//}
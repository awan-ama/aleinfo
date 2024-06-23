//package com.awanama.aleinfo.ui.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.awanama.aleinfo.data.entity.User
//import com.awanama.aleinfo.data.repository.UserRepository
//import kotlinx.coroutines.launch
//
//class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
//    var email: String = ""
//    var username: String = ""
//    var password: String = ""
//    var loginSuccessful: Boolean = false
//    var registerSuccessful: Boolean = false
//    var errorMessage: String? = null
//
//    fun login() {
//        viewModelScope.launch {
//            val user = userRepository.getUser(email, password)
//            loginSuccessful = user != null
//            if (!loginSuccessful) {
//                errorMessage = "Invalid email or password"
//            }
//        }
//    }
//
//    fun register() {
//        viewModelScope.launch {
//            val existingUser = userRepository.getUser(email, username)
//            if (existingUser == null) {
//                val newUser = User(email, username, password)
//                userRepository.insertUser(newUser)
//                registerSuccessful = true
//            } else {
//                registerSuccessful = false
//                errorMessage = "Email already exists"
//            }
//        }
//    }
//}
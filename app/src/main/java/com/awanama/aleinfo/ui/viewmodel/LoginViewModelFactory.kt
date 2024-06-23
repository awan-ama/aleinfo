//package com.awanama.aleinfo.ui.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.awanama.aleinfo.data.repository.UserRepository
//
//class LoginViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return LoginViewModel(userRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
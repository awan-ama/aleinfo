//package com.awanama.aleinfo.ui.home
//
//sealed interface HomeScreenUiState {
//    data object Initial : HomeScreenUiState
//    data object Loading : HomeScreenUiState
//    data class Success(val msg: com.awanama.aleinfo.data.entity.Message) : HomeScreenUiState
//    data class Error(val msg: String) : HomeScreenUiState
//}
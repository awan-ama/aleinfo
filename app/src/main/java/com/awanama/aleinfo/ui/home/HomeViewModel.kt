//package com.awanama.aleinfo.ui.home
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.awanama.aleinfo.repository.HomeRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class HomeViewModel @Inject constructor(
//    private val homeRepository: HomeRepository
//) : ViewModel() {
//    private val _response = MutableStateFlow<HomeScreenUiState>(HomeScreenUiState.Initial)
//    val response: StateFlow<HomeScreenUiState> = _response.asStateFlow()
//
//    fun loadData() {
//        viewModelScope.launch {
//            _response.value = HomeScreenUiState.Loading
//
//            try {
//                homeRepository.loadData().collect { message: com.awanama.aleinfo.data.entity.Message? ->
//                    message?.let { msg ->
//                        _response.value = HomeScreenUiState.Success(msg = msg)
//                    }
//                }
//            } catch (e: Exception) {
//                _response.value = HomeScreenUiState.Error(msg = e.message ?: "Something went wrong")
//            }
//        }
//    }
//}

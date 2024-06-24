package com.awanama.aleinfo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.model.Beer
import com.awanama.aleinfo.data.repository.BeerRepository
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val beerRepository = BeerRepository()

    fun fetchBeerById(beerId: Int, onResult: (Beer?) -> Unit) {
        viewModelScope.launch {
            val beers = beerRepository.getAles()
            val beer = beers.find { it.id == beerId}
            onResult(beer)
        }
    }
}
package com.awanama.aleinfo.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.entity.Beer
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
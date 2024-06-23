package com.awanama.aleinfo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.model.Beer
import com.awanama.aleinfo.data.repository.BeerRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BeerViewModel : ViewModel() {
    private val _beers = MutableStateFlow<List<Beer>>(emptyList())
    val beers: StateFlow<List<Beer>> get() = _beers

    init {
        fetchBeers()
    }

    private fun fetchBeers() {
        viewModelScope.launch {
            val alesDeferred = async { BeerRepository.getAles() }
            val fetchedBeers = alesDeferred.await()
            _beers.value = fetchedBeers
        }
    }

    fun getBeerById(id: Int): Beer? {
        val beerList = _beers.value
        if (beerList.isEmpty()) {
            fetchBeers()
        }
        return beerList.find { it.id == id }
    }
}

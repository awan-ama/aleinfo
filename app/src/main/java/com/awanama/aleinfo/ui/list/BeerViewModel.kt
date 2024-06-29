package com.awanama.aleinfo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanama.aleinfo.data.entity.Beer
import com.awanama.aleinfo.data.repository.BeerRepository
import kotlinx.coroutines.launch

class BeerViewModel : ViewModel() {

    private val beerRepository = BeerRepository()

    private val _beers = MutableLiveData<List<Beer>>()
    val beers: LiveData<List<Beer>> = _beers

    fun fetchBeers() {
        viewModelScope.launch {
            val fetchedBeers = beerRepository.getAles()
            _beers.value = fetchedBeers
        }
    }
}

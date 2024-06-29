package com.awanama.aleinfo.data.remote

import com.awanama.aleinfo.data.entity.Beer
import retrofit2.http.GET

interface BeerApiService {
    @GET("ale")
    suspend fun getAles(): List<Beer>
}
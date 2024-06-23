package com.awanama.aleinfo.data.repository

import com.awanama.aleinfo.data.model.Beer
import com.awanama.aleinfo.data.remote.BeerApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BeerRepository {
    private const val BASE_URL = "https://api.sampleapis.com/beers/"

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val api: BeerApiService by lazy {
        retrofit.create(BeerApiService::class.java)
    }

    suspend fun getAles(): List<Beer> {
        return api.getAles()
    }

}
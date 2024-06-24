package com.awanama.aleinfo.data.model

import com.squareup.moshi.Json

data class Beer(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: String,
    @Json(name = "image") val image: String
)
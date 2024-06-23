package com.awanama.aleinfo.data.model

import com.squareup.moshi.Json

data class Beer(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "price") val price: String,
    @Json(name = "rating") val rating: Rating,
    @Json(name = "image") val image: String
)

data class Rating(
    @Json(name = "average") val average: Double,
    @Json(name = "reviews") val reviews: Int
)

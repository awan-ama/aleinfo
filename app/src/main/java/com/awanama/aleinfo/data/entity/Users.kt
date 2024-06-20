package com.awanama.aleinfo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val usersId: Long = 0,
    var email: String,
    var usename: String,
    var password: String,
)

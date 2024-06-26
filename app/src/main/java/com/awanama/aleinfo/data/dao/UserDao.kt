package com.awanama.aleinfo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.awanama.aleinfo.data.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): User?

    @Query("SELECT * FROM user")
    suspend fun getAllUser(): List<User>

    @Query("SELECT * FROM user WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?
}
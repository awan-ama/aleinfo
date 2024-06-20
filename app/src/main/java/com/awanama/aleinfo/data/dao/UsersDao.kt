package com.awanama.aleinfo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.awanama.aleinfo.data.entity.Users

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: Users): Long

    @Query("SELECT * FROM Users WHERE email LIKE :email AND password LIKE :password")
    fun readLoginData(email: String, password: String): Users

    @Query("SELECT * FROM Users WHERE usersId Like :usersId")
    fun getUserDataDetails(usersId:Long): Users

//    @Query("DELETE FROM Users WHERE usersId Like :usersId")
//    fun deleteUser(usersId:Long): Users
}
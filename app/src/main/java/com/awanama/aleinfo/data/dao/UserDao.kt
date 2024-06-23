//package com.awanama.aleinfo.data.dao
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import com.awanama.aleinfo.data.entity.User
//
//@Dao
//interface UserDao {
//    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
//    fun getUser(username: String, password: String): User?
//
//    @Insert
//    suspend fun insertUser(user: User)
//
//    @Delete
//    suspend fun deleteUser(user: User)
//}
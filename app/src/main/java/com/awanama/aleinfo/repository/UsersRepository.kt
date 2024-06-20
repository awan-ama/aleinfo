package com.awanama.aleinfo.repository

import com.awanama.aleinfo.data.entity.Users

interface UsersRepository {
    fun insertUser(users: Users): Long
    fun readLoginData(email: String, password: String): Users
    fun getUserDataDetails(usersId:Long): Users
//    fun deleteUser(usersId:Long): Users
}
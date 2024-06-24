package com.awanama.aleinfo.data.repository

import com.awanama.aleinfo.data.dao.UserDao
import com.awanama.aleinfo.data.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun getUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }
}

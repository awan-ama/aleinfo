package com.awanama.aleinfo.data.repository

import com.awanama.aleinfo.data.dao.UserDao
import com.awanama.aleinfo.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun getUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}

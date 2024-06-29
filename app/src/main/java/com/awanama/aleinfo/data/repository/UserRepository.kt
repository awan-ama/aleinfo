package com.awanama.aleinfo.data.repository

import com.awanama.aleinfo.data.dao.UserDao
import com.awanama.aleinfo.data.entity.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun getUser(username: String, password: String): User? {
        return userDao.getUser(username, password)
    }

    suspend fun getAllUser(): List<User> {
        return userDao.getAllUser()
    }

    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}

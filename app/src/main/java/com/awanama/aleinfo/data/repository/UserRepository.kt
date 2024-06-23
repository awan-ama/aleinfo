//package com.awanama.aleinfo.data.repository
//
//import com.awanama.aleinfo.data.dao.UserDao
//import com.awanama.aleinfo.data.entity.User
//
//class UserRepository(private val userDao: UserDao) {
//    fun getUser(email: String, password: String): User? {
//        return userDao.getUser(email, password)
//    }
//
//    fun insertUser(user: User) {
//        userDao.insertUser(user)
//    }
//}
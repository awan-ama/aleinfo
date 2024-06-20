package com.awanama.aleinfo.repository

import com.awanama.aleinfo.data.dao.UsersDao
import com.awanama.aleinfo.data.entity.Users
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private var usersDao: UsersDao,
) : UsersRepository{
    override fun insertUser(users: Users): Long {
        return usersDao.insertUser(users)
    }
    override fun readLoginData(email: String, password: String): Users {
        return usersDao.readLoginData(email, password)
    }
//    override fun deleteUser(usersId:Long): Users{
//        return usersDao.deleteUser(usersId)
//    }
    override fun getUserDataDetails(usersId:Long): Users {
        return usersDao.getUserDataDetails(usersId)
    }

}
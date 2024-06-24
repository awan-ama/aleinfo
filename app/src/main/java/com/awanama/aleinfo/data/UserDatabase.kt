package com.awanama.aleinfo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awanama.aleinfo.data.dao.UserDao
import com.awanama.aleinfo.data.model.User

@Database(
    version = 1,
    entities = [User::class],
    exportSchema = true
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
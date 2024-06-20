package com.awanama.aleinfo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awanama.aleinfo.data.entity.Users

@Database(
    version = 1,
    entities = [com.awanama.aleinfo.data.entity.Message::class, Users::class],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): com.awanama.aleinfo.data.dao.MessageDao
    abstract fun usersDao(): com.awanama.aleinfo.data.dao.UsersDao
}

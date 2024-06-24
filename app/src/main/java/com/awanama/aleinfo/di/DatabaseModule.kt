package com.awanama.aleinfo.di

import android.content.Context
import androidx.room.Room
import com.awanama.aleinfo.data.UserDatabase
import com.awanama.aleinfo.data.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao {
        return database.userDao()
    }
}

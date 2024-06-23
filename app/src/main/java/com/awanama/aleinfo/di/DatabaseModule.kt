//package com.awanama.aleinfo.di
//
//import android.content.Context
//import androidx.room.Room
//import com.awanama.aleinfo.R
//import com.awanama.aleinfo.data.RoomDbInitializer
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Provider
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class DatabaseModule {
//    @Singleton
//    @Provides
//    fun provideAppDatabase(
//        @ApplicationContext context: Context,
//        messageDaoProvider: Provider<com.awanama.aleinfo.data.dao.MessageDao>
//    ): com.awanama.aleinfo.data.AppDatabase {
//        return Room.databaseBuilder(
//            context.applicationContext, com.awanama.aleinfo.data.AppDatabase::class.java, context.getString(
//                R.string.app_name
//            )
//        ).addCallback(
//            /**
//             * Attach [RoomDbInitializer] as callback to the database
//             */
//            com.awanama.aleinfo.data.RoomDbInitializer(
//                context = context,
//                messageDaoProvider = messageDaoProvider
//            )
//        )
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideMessageDao(appDatabase: com.awanama.aleinfo.data.AppDatabase): com.awanama.aleinfo.data.dao.MessageDao = appDatabase.messageDao()
//}

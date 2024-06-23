//package com.awanama.aleinfo.data
//
//import android.content.Context
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.awanama.aleinfo.R
//import com.awanama.aleinfo.data.dao.MessageDao
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.SupervisorJob
//import kotlinx.coroutines.launch
//import javax.inject.Provider
//
///**
// * This class implements [RoomDatabase.Callback] and override [RoomDatabase.Callback.onCreate] method
// * to initialise room database when it's created for the first time.
// * We're using [Provider] of [MessageDao] to break the circular dependency.
// */
//class RoomDbInitializer(
//    private val context: Context,
//    private val messageDaoProvider: Provider<com.awanama.aleinfo.data.dao.MessageDao>
//) : RoomDatabase.Callback() {
//    private val applicationScope = CoroutineScope(SupervisorJob())
//
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//        applicationScope.launch(Dispatchers.IO) {
//            populateDatabase()
//        }
//    }
//
//    private suspend fun populateDatabase() {
//        messageDaoProvider.get().insertOrUpdateMessage(
//            com.awanama.aleinfo.data.entity.Message(text = context.getString(R.string.welcome_message))
//        )
//    }
//}

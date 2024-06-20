package com.awanama.aleinfo.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {
    @Upsert
    suspend fun insertOrUpdateMessage(message: com.awanama.aleinfo.data.entity.Message): Long

    /**
     * As we're using Kotlin CodeGen for Room, we need to mark Message as nullable.
     * Refer @link https://developer.android.com/jetpack/androidx/releases/room#2.6.0 for more info.
     */
    @Query("SELECT * FROM Message LIMIT 1")
    fun getMessage(): Flow<com.awanama.aleinfo.data.entity.Message?>
}

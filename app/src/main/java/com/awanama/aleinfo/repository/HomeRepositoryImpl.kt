//package com.awanama.aleinfo.repository
//
//import com.awanama.aleinfo.data.dao.MessageDao
//import com.awanama.aleinfo.data.entity.Message
//import kotlinx.coroutines.flow.Flow
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class HomeRepositoryImpl @Inject constructor(
//    private val messageDao: MessageDao
//) : HomeRepository {
//    override fun loadData(): Flow<Message?> {
//        return messageDao.getMessage()
//    }
//}
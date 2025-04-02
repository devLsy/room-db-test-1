package com.lsy.roomdb_1.data.db.repository

import com.lsy.roomdb_1.data.db.dao.UserDao
import com.lsy.roomdb_1.data.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    suspend fun insert(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun update(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun delete(user: UserEntity) {
        userDao.deleteUser(user)
    }
}
package com.plast.app.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.plast.app.data.local.database.entity.UserEntity

@Dao
interface UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE userId = :userId")
    fun getUserById(userId: Int): LiveData<UserEntity>

    @Query("DELETE FROM user WHERE userId = :userId")
    fun deleteUserById(userId: Int)
}
package com.plast.app.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.plast.app.data.local.database.entity.CardEntity

@Dao
interface CardDao : BaseDao<CardEntity> {

    @Query("SELECT * FROM cardDao")
    fun getAllCards(): LiveData<List<CardEntity>>

    @Query("SELECT * FROM cardDao WHERE cardPos = :cardPos")
    fun getCardByPos(cardPos: Int): LiveData<CardEntity>

    @Query("DELETE FROM cardDao WHERE cardPos = :cardPos")
    fun deleteCardByPos(cardPos: Int)
}
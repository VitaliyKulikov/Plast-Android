package com.plast.app.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cardDao")
data class CardEntity(
        @PrimaryKey
        @SerializedName("cardPos") val cardPos: Int,
        @SerializedName("plastCoin") val plastCoin: Int,
        @SerializedName("imageRes") val imageRes: Int,
        @SerializedName("titleResId") val titleResId: Int,
        @SerializedName("descriptionResId") val descriptionResId: Int,
        @SerializedName("cardState") var cardState: Int = -1
)

const val DONE = 1
const val CURRENT = 2
const val LOCKED = 3
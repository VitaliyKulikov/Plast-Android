package com.plast.app.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @SerializedName("userId") val userId: Int,
    @SerializedName("firstname") val firstName: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("avatarUrl") val avatarUrl: String
)
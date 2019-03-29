package com.bbook.app.models.network

import com.google.gson.annotations.SerializedName

data class CommonServerError(val errorCode:String,
                             @SerializedName("title")
                               val title: String,
                             @SerializedName("message")
                             val message: String)
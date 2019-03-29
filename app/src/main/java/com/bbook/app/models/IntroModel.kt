package com.bbook.app.models

import com.google.gson.annotations.SerializedName

class IntroModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String
)
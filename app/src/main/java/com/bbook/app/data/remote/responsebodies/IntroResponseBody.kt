package com.bbook.app.data.remote.responsebodies

import com.google.gson.annotations.SerializedName
import com.bbook.app.models.IntroModel

data class IntroResponseBody(
    @SerializedName("success") val success: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: List<IntroModel>)
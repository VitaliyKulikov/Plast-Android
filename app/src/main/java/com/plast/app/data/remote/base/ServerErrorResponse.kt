package com.plast.app.data.remote.base

import com.google.gson.annotations.SerializedName
import com.plast.app.models.network.CommonServerError

data class ServerErrorResponse(
        @SerializedName("success") val isSuccess: Boolean,
        @SerializedName("error") val serverError: CommonServerError?)
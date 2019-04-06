package com.plast.app.api

import com.plast.app.data.remote.responsebodies.IntroResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ContentApi {

    @GET("content/intro")
    fun getOnboardingData(): Call<IntroResponseBody>
}
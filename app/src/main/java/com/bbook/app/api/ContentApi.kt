package com.bbook.app.api

import com.bbook.app.data.remote.responsebodies.IntroResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ContentApi {

    @GET("content/intro")
    fun getOnboardingData(): Call<IntroResponseBody>
}
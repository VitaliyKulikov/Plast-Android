package com.bbook.app.repositories

import androidx.lifecycle.MutableLiveData
import com.bbook.app.AppExecutors
import com.bbook.app.data.remote.api.ContentApi
import com.bbook.app.data.remote.responsebodies.IntroResponseBody
import com.bbook.app.models.IntroModel
import com.bbook.app.models.network.NetworkState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ContentRepository
@Inject constructor(
    private val contentApi: ContentApi,
    val executor:AppExecutors

) {
    val networkState = MutableLiveData<NetworkState>()

    fun getOnboardingData(onSuccess: (introModel : List<IntroModel>) -> Unit) {
        networkState.postValue(NetworkState.LOADING)
        executor.ioExecutor.execute {
            val call = contentApi.getOnboardingData()
            val callback = object : Callback<IntroResponseBody> {
                override fun onResponse(call: Call<IntroResponseBody>?, response: Response<IntroResponseBody>?) {
                    response?.body()?.let {
                        networkState.postValue(NetworkState.SUCCESSFUL)
                        onSuccess(it.data)
                    }
                }

                override fun onFailure(call: Call<IntroResponseBody>?, t: Throwable?) {
                    networkState.postValue(NetworkState.error(t))
                }
            }
            call.enqueue(callback)
        }
    }
}
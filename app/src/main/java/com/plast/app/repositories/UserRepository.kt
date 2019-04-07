package com.plast.app.repositories

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.plast.app.AppExecutors
import com.plast.app.api.UserApi
import com.plast.app.data.local.AppDatabase
import com.plast.app.data.local.database.entity.UserEntity
import com.plast.app.models.network.NetworkState
import javax.inject.Inject


//example
class UserRepository
@Inject constructor(
    private val appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    userApi: UserApi
) {
    val networkState = MutableLiveData<NetworkState>()

    fun getUser(onSuccess: (user: UserEntity) -> Unit) {
        networkState.postValue(NetworkState.LOADING)
        appExecutors.ioExecutor.execute {
            networkState.postValue(NetworkState.LOADING)
            val user = FirebaseAuth.getInstance().currentUser
            val uid = user?.uid
            uid?.let { safeId ->
                networkState.postValue(NetworkState.SUCCESSFUL)
                onSuccess(
                    UserEntity(
                        safeId,
                        user.displayName ?: "",
                        user.photoUrl.toString()
                    )
                )
            }
        }
    }
}
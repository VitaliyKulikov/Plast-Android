package com.plast.app.repositories

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.plast.app.AppExecutors
import com.plast.app.api.UserApi
import com.plast.app.data.local.AppDatabase
import com.plast.app.data.local.database.entity.UserEntity
import com.plast.app.models.network.NetworkState
import javax.inject.Inject
import com.google.firebase.database.FirebaseDatabase




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
                val user  =UserEntity(
                    safeId,
                    user.displayName ?: "",
                    user.photoUrl.toString()
                )
                onSuccess(user)
            }
        }
    }
    fun setUpUser(){
        appExecutors.ioExecutor.execute {
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            firebaseUser?.uid?.let { userId ->
                val userIdRef = FirebaseDatabase.getInstance().getReference(USERS).child(userId)
                userIdRef.child(AVATAR).setValue(firebaseUser.photoUrl.toString())
                userIdRef.child(COINS).setValue(0)
                userIdRef.child(CURRENT_STEP).setValue(0)
                userIdRef.child(MAIL).setValue(firebaseUser.email.toString())
                userIdRef.child(NAME).setValue(firebaseUser.displayName.toString())
            }
        }
    }

    companion object {
        const val USERS = "users"
        const val AVATAR = "avatar"
        const val COINS = "coins"
        const val CURRENT_STEP = "current_step"
        const val MAIL = "mail"
        const val NAME = "name"
    }
}
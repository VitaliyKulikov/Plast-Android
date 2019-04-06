package com.plast.app.features.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.plast.app.data.local.sharedpreferences.SyncSharedPreferences
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sharedPreferences: SyncSharedPreferences
) : ViewModel() {
    private val mAuth = FirebaseAuth.getInstance()
    val loginedLiveData by lazy { MutableLiveData<Boolean>() }

    private val userLoginedResult = MutableLiveData<Boolean>()

    fun signInViaGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("SignIn Presenter", "signInWithCredential:success")
                    loginedLiveData.postValue(true)
                    sharedPreferences.setLoggedIn(true)
                } else {
                    Log.w("SignIn Presenter", "signInWithCredential:failure", task.exception)
                }
            }
    }
}
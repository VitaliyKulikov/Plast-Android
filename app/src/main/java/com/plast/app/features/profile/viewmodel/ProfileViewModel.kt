package com.plast.app.features.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.data.local.database.entity.UserEntity
import com.plast.app.models.network.NetworkState
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val coinsLiveData = userRepository.coinsLiveData
    val currentStepLiveData = userRepository.currentStepLiveData

    private val _userLiveData by lazy{MutableLiveData<UserEntity>()}
    val userLiveData: LiveData<UserEntity>
        get() {
            userRepository.getUser { user ->
                _userLiveData.postValue(user)
    }
            return _userLiveData
        }
}
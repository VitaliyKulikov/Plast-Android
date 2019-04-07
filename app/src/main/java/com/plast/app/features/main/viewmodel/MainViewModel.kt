package com.plast.app.features.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.data.local.database.entity.UserEntity
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
private val userRepository: UserRepository
) : ViewModel() {

    private val _userLiveData by lazy{ MutableLiveData<UserEntity>() }
    val userLiveData: LiveData<UserEntity>
        get() {
            userRepository.getUser { user ->
                _userLiveData.postValue(user)
            }
            return _userLiveData
        }
}
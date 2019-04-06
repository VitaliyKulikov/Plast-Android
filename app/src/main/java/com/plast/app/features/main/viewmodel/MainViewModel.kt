package com.plast.app.features.main.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()//todo example delete it :)
}
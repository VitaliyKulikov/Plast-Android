package com.plast.app.features.login.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
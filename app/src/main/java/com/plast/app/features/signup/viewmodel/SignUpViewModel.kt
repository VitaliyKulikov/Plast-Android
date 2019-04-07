package com.plast.app.features.signup.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser({

    })
}
package com.bbook.app.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import com.bbook.app.repositories.UserRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
package com.bbook.app.ui.main.profile.viewmodel

import androidx.lifecycle.ViewModel
import com.bbook.app.repositories.UserRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
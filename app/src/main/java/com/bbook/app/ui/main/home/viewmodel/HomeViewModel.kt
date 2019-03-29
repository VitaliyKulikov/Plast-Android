package com.bbook.app.ui.main.home.viewmodel

import androidx.lifecycle.ViewModel
import com.bbook.app.repositories.UserRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
package com.bbook.app.ui.main.notification.viewmodel

import androidx.lifecycle.ViewModel
import com.bbook.app.repositories.UserRepository
import javax.inject.Inject

class MotificationViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
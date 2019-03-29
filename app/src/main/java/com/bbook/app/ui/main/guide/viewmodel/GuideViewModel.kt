package com.bbook.app.ui.main.guide.viewmodel

import androidx.lifecycle.ViewModel
import com.bbook.app.repositories.UserRepository
import javax.inject.Inject

class GuideViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
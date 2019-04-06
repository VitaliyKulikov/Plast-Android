package com.plast.app.features.main.guide.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class GuideViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
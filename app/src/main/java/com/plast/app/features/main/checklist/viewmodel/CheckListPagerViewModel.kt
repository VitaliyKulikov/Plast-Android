package com.plast.app.features.main.checklist.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.repositories.UserRepository
import javax.inject.Inject

class CheckListPagerViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUser() = userRepository.getUser()
}
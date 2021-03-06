package com.bbook.app.ui.onboarding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bbook.app.data.local.sharedpreferences.SyncSharedPreferences
import com.bbook.app.models.IntroModel
import com.bbook.app.repositories.ContentRepository
import javax.inject.Inject

class OnBoardViewModel @Inject constructor(
    private val sp: SyncSharedPreferences,
    private val repo: ContentRepository
) : ViewModel() {

    private val _onboardingLiveData by lazy{MutableLiveData<List<IntroModel>>()}
    val onboardingLiveData: LiveData<List<IntroModel>>
    get() {
        repo.getOnboardingData {
            _onboardingLiveData.postValue(it)
        }
        return _onboardingLiveData
    }


    fun setOnboardingDone(){
        sp.setOnBoardingPassed(true)
    }
}
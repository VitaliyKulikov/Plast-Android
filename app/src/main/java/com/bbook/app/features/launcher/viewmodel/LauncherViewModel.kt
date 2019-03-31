package com.bbook.app.features.launcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bbook.app.data.local.result.Event
import com.bbook.app.data.local.sharedpreferences.SyncSharedPreferences
import com.bbook.app.toolbox.extensions.map
import javax.inject.Inject

/**
 * Logic for determining which screen to send users to on app launch.
 */
class LaunchViewModel @Inject constructor(
    sharedPreferences: SyncSharedPreferences
) : ViewModel() {

    private val onboardingCompletedResult = MutableLiveData<Boolean>()
    private val userLoginedResult = MutableLiveData<Boolean>()
    val launchDestination: LiveData<Event<LaunchDestination>>

    init {
        userLoginedResult.postValue(sharedPreferences.isLoggedIn())
        onboardingCompletedResult.postValue(sharedPreferences.isOnboardingPassed())
        launchDestination = onboardingCompletedResult.map {
            // If this check fails, prefer to launch login activity than show onboarding too often
            if (it == false) {
                Event(LaunchDestination.ONBOARDING)
            } else {
                if (userLoginedResult.value == true) {
                    Event(LaunchDestination.MAIN_ACTIVITY)
                } else {
                    Event(LaunchDestination.LOGIN)
                }
            }
        }
    }
}

enum class LaunchDestination {
    ONBOARDING,
    MAIN_ACTIVITY,
    LOGIN,
}

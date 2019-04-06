package com.plast.app.data.local.sharedpreferences

import android.content.Context
import javax.inject.Singleton

@Singleton
class SyncSharedPreferences(context: Context) : AppSharedPreferences {

    companion object {
        const val SHARED_PREFERENCES_NAME = "sp_start_plast"
        const val KEY_IS_LOGGED_IN = "pref_is_logged_in"
        const val KEY_IS_ONBOARDING_PASSED = "pref_is_onboard_passed"
        const val KEY_CURRENT_USER_ID = "pref_current_user_id"
    }

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )

    override fun isLoggedIn(): Boolean = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    override fun setLoggedIn(loggedIn: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(KEY_IS_LOGGED_IN, loggedIn)
            .apply()
    }

    override fun isOnboardingPassed(): Boolean = sharedPreferences.getBoolean(KEY_IS_ONBOARDING_PASSED, false)
    override fun setOnBoardingPassed(passed: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(KEY_IS_ONBOARDING_PASSED, passed)
            .apply()
    }

    override fun getCurrentUserId(): Int = sharedPreferences.getInt(KEY_CURRENT_USER_ID, 0)
    override fun setCurrentUserId(id: Int) {
        sharedPreferences
            .edit()
            .putInt(KEY_CURRENT_USER_ID, id)
            .apply()
    }

    fun clearUser() {
        sharedPreferences.edit()
            .remove(KEY_CURRENT_USER_ID)
            .remove(KEY_IS_LOGGED_IN)
            .apply()
    }
}
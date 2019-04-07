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
        const val KEY_CURRENT_USER_CHECK_POINT = "pref_current_user_check_point"
    }

    private val sp = context.getSharedPreferences(
            SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
    )

    override fun isLoggedIn(): Boolean = sp.getBoolean(KEY_IS_LOGGED_IN, false)
    override fun setLoggedIn(loggedIn: Boolean) {
        sp
                .edit()
                .putBoolean(KEY_IS_LOGGED_IN, loggedIn)
                .apply()
    }

    override fun isOnboardingPassed(): Boolean = sp.getBoolean(KEY_IS_ONBOARDING_PASSED, false)
    override fun setOnBoardingPassed(passed: Boolean) {
        sp
                .edit()
                .putBoolean(KEY_IS_ONBOARDING_PASSED, passed)
                .apply()
    }

    override fun getCurrentUserId(): Int = sp.getInt(KEY_CURRENT_USER_ID, 0)
    override fun setCurrentUserId(id: Int) {
        sp
                .edit()
                .putInt(KEY_CURRENT_USER_ID, id)
                .apply()
    }

    override fun getCurrentUserCheckPoint() = sp.getInt(KEY_CURRENT_USER_CHECK_POINT, 0)

    override fun setCurrentUserCheckPoint(position: Int) {
        sp.edit().putInt(KEY_CURRENT_USER_CHECK_POINT, position).apply()
    }

    fun clearUser() {
        sp.edit()
                .remove(KEY_CURRENT_USER_CHECK_POINT)
                .remove(KEY_CURRENT_USER_ID)
                .remove(KEY_IS_LOGGED_IN)
                .apply()
    }
}
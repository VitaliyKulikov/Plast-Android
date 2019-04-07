package com.plast.app.di.modules

import com.plast.app.features.details.DetailsActivity
import com.plast.app.features.launcher.LauncherActivity
import com.plast.app.features.login.LoginActivity
import com.plast.app.features.main.MainActivity
import com.plast.app.features.onboarding.OnboardingActivity
import com.plast.app.features.profile.ProfileActivity
import com.plast.app.features.signup.SignUpActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector
    fun contributeLauncher(): LauncherActivity

    @ContributesAndroidInjector
    fun contributeLogin(): LoginActivity

    @ContributesAndroidInjector
    fun contributeMain(): MainActivity

    @ContributesAndroidInjector
    fun contributeOnboarding(): OnboardingActivity

    @ContributesAndroidInjector
    fun contributeSignUp(): SignUpActivity

    @ContributesAndroidInjector
    fun contributeProfile(): ProfileActivity

    @ContributesAndroidInjector
    fun contributeDetails(): DetailsActivity
}
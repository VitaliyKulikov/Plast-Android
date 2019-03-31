package com.bbook.app.di.modules

import com.bbook.app.features.launcher.LauncherActivity
import com.bbook.app.features.login.LoginActivity
import com.bbook.app.features.main.MainActivity
import com.bbook.app.features.onboarding.OnboardingActivity
import com.bbook.app.features.signup.SignUpActivity

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
}
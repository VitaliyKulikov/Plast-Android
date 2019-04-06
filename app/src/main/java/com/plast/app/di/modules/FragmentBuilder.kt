package com.plast.app.di.modules

import com.plast.app.features.login.fragments.LoginFragment
import com.plast.app.features.onboarding.fragments.OnBoardingFragment
import com.plast.app.features.signup.fragments.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {

    @ContributesAndroidInjector()
    fun provideOnBoardingFragment(): OnBoardingFragment

    @ContributesAndroidInjector
    fun provideSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginFragment

}
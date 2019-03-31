package com.bbook.app.di.modules

import com.bbook.app.features.login.fragments.LoginFragment
import com.bbook.app.features.main.guide.fragments.GuideFragment
import com.bbook.app.features.main.home.fragments.HomeFragment
import com.bbook.app.features.main.notification.fragments.NotificationFragment
import com.bbook.app.features.main.profile.fragments.ProfileFragment
import com.bbook.app.features.onboarding.fragments.OnBoardingFragment
import com.bbook.app.features.signup.fragments.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {
    @ContributesAndroidInjector()
    fun provideHiveFragment(): HomeFragment

    @ContributesAndroidInjector()
    fun provideFavoriteFragment(): ProfileFragment

    @ContributesAndroidInjector()
    fun provideNotificationFragment(): NotificationFragment

    @ContributesAndroidInjector()
    fun provideGuideFragment(): GuideFragment

    @ContributesAndroidInjector()
    fun provideOnBoardingFragment(): OnBoardingFragment

    @ContributesAndroidInjector
    fun provideSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginFragment

}
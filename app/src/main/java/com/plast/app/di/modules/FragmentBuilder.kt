package com.plast.app.di.modules

import com.plast.app.features.login.fragments.LoginFragment
import com.plast.app.features.main.checklist.fragments.CheckListPagerFragment
import com.plast.app.features.main.guide.fragments.GuideFragment
import com.plast.app.features.main.home.fragments.HomeFragment
import com.plast.app.features.main.notification.fragments.NotificationFragment
import com.plast.app.features.main.profile.fragments.ProfileFragment
import com.plast.app.features.onboarding.fragments.OnBoardingFragment
import com.plast.app.features.signup.fragments.SignUpFragment
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

    @ContributesAndroidInjector
    fun provideCheckListPagerFragment(): CheckListPagerFragment

}
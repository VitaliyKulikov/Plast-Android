package com.bbook.app.ui.main.modules

import com.bbook.app.ui.main.guide.fragments.GuideFragment
import com.bbook.app.ui.main.home.fragments.HomeFragment
import com.bbook.app.ui.main.notification.fragments.NotificationFragment
import com.bbook.app.ui.main.profile.fragments.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector()
    abstract fun provideHiveFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun provideFavoriteFragment(): ProfileFragment

    @ContributesAndroidInjector()
    abstract fun provideNotificationFragment(): NotificationFragment

    @ContributesAndroidInjector()
    abstract fun provideGuideFragment(): GuideFragment
}
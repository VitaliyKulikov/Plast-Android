package com.bbook.app.ui.onboarding.modules

import com.bbook.app.ui.onboarding.fragments.OnBoardingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OnBoardingFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFragment(): OnBoardingFragment
}
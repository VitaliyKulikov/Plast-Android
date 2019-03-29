package com.bbook.app.ui.onboarding.modules

import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.ui.onboarding.OnboardingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class OnBoardingActivityModule {
    @ContributesAndroidInjector(modules = [OnBoardingFragmentModule::class])
    abstract fun contributeRecognitionActivity(): OnboardingActivity
}
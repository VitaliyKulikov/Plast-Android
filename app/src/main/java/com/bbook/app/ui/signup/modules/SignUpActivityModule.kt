package com.bbook.app.ui.signup.modules

import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.ui.signup.SignUpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class SignUpActivityModule {
    @ContributesAndroidInjector(modules = [SignUpFragmentModule::class])
    abstract fun contributeRecognitionActivity(): SignUpActivity
}
package com.bbook.app.ui.login.modules

import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class LoginActivityModule {
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    abstract fun contributeRecognitionActivity(): LoginActivity
}
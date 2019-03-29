package com.bbook.app.ui.main.modules

import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeRecognitionActivity(): MainActivity
}
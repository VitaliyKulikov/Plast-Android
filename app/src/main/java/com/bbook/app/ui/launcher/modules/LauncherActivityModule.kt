package com.bbook.app.ui.launcher.modules

import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.ui.launcher.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [AppViewModelsComponent::class])
abstract class LauncherActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeRecognitionActivity(): LauncherActivity
}
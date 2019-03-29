package com.bbook.app.di.modules

import com.bbook.app.AppViewModelsFactory
import com.bbook.app.di.AppViewModelsComponent
import dagger.Module
import dagger.Provides

@Module
class AppViewModelsFactoryModule {

    @Provides
    fun provideAppViewModelFactory(builder: AppViewModelsComponent.Builder): AppViewModelsFactory {
        return AppViewModelsFactory(builder.build())
    }
}
package com.bbook.app.di.modules

import android.app.Application
import com.bbook.app.AppExecutors
import com.bbook.app.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideDatabase(app: Application, executors: AppExecutors): AppDatabase {
        return AppDatabase.getInstance(app, executors)
    }
}
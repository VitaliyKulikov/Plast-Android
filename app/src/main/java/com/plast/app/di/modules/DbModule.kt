package com.plast.app.di.modules

import android.app.Application
import com.plast.app.AppExecutors
import com.plast.app.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideDatabase(app: Application, executors: AppExecutors): AppDatabase {
        return AppDatabase.getInstance(app, executors)
    }
}
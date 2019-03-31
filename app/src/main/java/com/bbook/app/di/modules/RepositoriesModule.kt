package com.bbook.app.di.modules

import com.bbook.app.AppExecutors
import com.bbook.app.data.local.AppDatabase
import com.bbook.app.api.UserApi
import com.bbook.app.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideUserRepository(
        appDatabase: AppDatabase,
        appExecutors: AppExecutors,
        userApi: UserApi
    ): UserRepository {
        return UserRepository(appDatabase, appExecutors, userApi)
    }
}
package com.plast.app.di.modules

import com.plast.app.AppExecutors
import com.plast.app.api.UserApi
import com.plast.app.data.local.AppDatabase
import com.plast.app.data.local.sharedpreferences.SyncSharedPreferences
import com.plast.app.repositories.CardRepository
import com.plast.app.repositories.UserRepository
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

    @Provides
    fun provideCardRepository(appDatabase: AppDatabase,
                              appExecutors: AppExecutors,
                              sharedPreferences: SyncSharedPreferences
    ) = CardRepository(appDatabase, appExecutors, sharedPreferences)
}

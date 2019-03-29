package com.bbook.app.di

import android.app.Application
import com.bbook.app.BaseApplication
import com.bbook.app.di.modules.*
import com.bbook.app.ui.launcher.modules.LauncherActivityModule
import com.bbook.app.ui.login.modules.LoginActivityModule
import com.bbook.app.ui.main.modules.MainActivityModule
import com.bbook.app.ui.onboarding.modules.OnBoardingActivityModule
import com.bbook.app.ui.signup.modules.SignUpActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*Global Component*/
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppViewModelsFactoryModule::class,
        DbModule::class,
        ExecutorsModule::class,
        RepositoriesModule::class,
        SpModule::class,
        NetworkModule::class,
        AppApiModule::class,

        // activities module
        LauncherActivityModule::class,
        OnBoardingActivityModule::class,
        LoginActivityModule::class,
        MainActivityModule::class,
        SignUpActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}
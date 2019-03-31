package com.bbook.app.di

import com.bbook.app.features.launcher.viewmodel.LaunchViewModel
import com.bbook.app.features.login.viewmodel.LoginViewModel
import com.bbook.app.features.main.guide.viewmodel.GuideViewModel
import com.bbook.app.features.onboarding.viewmodel.OnBoardViewModel
import com.bbook.app.features.signup.viewmodel.SignUpViewModel
import dagger.Subcomponent

@Subcomponent
interface AppViewModelsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): AppViewModelsComponent
    }

    fun provideLaunchViewModel(): LaunchViewModel
    fun provideOnBoardViewModel(): OnBoardViewModel
    fun provideLoginViewModel(): LoginViewModel
    fun provideMainViewModel(): GuideViewModel
    fun provideSignUpViewModel(): SignUpViewModel
}
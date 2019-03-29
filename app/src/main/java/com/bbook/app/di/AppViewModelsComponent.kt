package com.bbook.app.di

import com.bbook.app.ui.launcher.viewmodel.LaunchViewModel
import com.bbook.app.ui.login.viewmodel.LoginViewModel
import com.bbook.app.ui.main.guide.viewmodel.GuideViewModel
import com.bbook.app.ui.onboarding.viewmodel.OnBoardViewModel
import com.bbook.app.ui.signup.viewmodel.SignUpViewModel
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
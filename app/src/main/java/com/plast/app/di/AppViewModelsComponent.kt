package com.plast.app.di

import com.plast.app.features.launcher.viewmodel.LaunchViewModel
import com.plast.app.features.login.viewmodel.LoginViewModel
import com.plast.app.features.main.checklist.viewmodel.CheckListPagerViewModel
import com.plast.app.features.main.guide.viewmodel.GuideViewModel
import com.plast.app.features.onboarding.viewmodel.OnBoardViewModel
import com.plast.app.features.signup.viewmodel.SignUpViewModel
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
    fun provideSignUpViewModel(): SignUpViewModel
    fun provideCheckListPagerViewModel(): CheckListPagerViewModel
}
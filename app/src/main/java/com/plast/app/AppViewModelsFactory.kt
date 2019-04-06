package com.plast.app

import androidx.collection.ArrayMap
import androidx.lifecycle.ViewModel
import com.plast.app.di.AppViewModelsComponent
import com.plast.app.features.launcher.viewmodel.LaunchViewModel
import com.plast.app.features.login.viewmodel.LoginViewModel
import com.plast.app.features.main.checklist.viewmodel.CheckListPagerViewModel
import com.plast.app.features.main.guide.viewmodel.GuideViewModel
import com.plast.app.features.onboarding.viewmodel.OnBoardViewModel
import com.plast.app.features.signup.viewmodel.SignUpViewModel
import java.util.concurrent.Callable

class AppViewModelsFactory(private val appViewModelsComponent: AppViewModelsComponent) :
    BaseViewModelFactory() {

    override fun fillViewModels(creators: ArrayMap<Class<*>, Callable<out ViewModel>>) {
        creators[LaunchViewModel::class.java] = Callable { appViewModelsComponent.provideLaunchViewModel() }
        creators[OnBoardViewModel::class.java] = Callable { appViewModelsComponent.provideOnBoardViewModel() }
        creators[LoginViewModel::class.java] = Callable { appViewModelsComponent.provideLoginViewModel() }
        creators[SignUpViewModel::class.java] = Callable { appViewModelsComponent.provideSignUpViewModel() }
        creators[CheckListPagerViewModel::class.java] = Callable { appViewModelsComponent.provideCheckListPagerViewModel() }
    }
}
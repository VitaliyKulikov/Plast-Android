package com.bbook.app

import androidx.collection.ArrayMap
import androidx.lifecycle.ViewModel
import com.bbook.app.di.AppViewModelsComponent
import com.bbook.app.features.launcher.viewmodel.LaunchViewModel
import com.bbook.app.features.login.viewmodel.LoginViewModel
import com.bbook.app.features.main.guide.viewmodel.GuideViewModel
import com.bbook.app.features.onboarding.viewmodel.OnBoardViewModel
import com.bbook.app.features.signup.viewmodel.SignUpViewModel
import java.util.concurrent.Callable

class AppViewModelsFactory(private val appViewModelsComponent: AppViewModelsComponent) :
    BaseViewModelFactory() {

    override fun fillViewModels(creators: ArrayMap<Class<*>, Callable<out ViewModel>>) {
        creators[LaunchViewModel::class.java] = Callable { appViewModelsComponent.provideLaunchViewModel() }
        creators[OnBoardViewModel::class.java] = Callable { appViewModelsComponent.provideOnBoardViewModel() }
        creators[LoginViewModel::class.java] = Callable { appViewModelsComponent.provideLoginViewModel() }
        creators[GuideViewModel::class.java] = Callable { appViewModelsComponent.provideMainViewModel() }
        creators[SignUpViewModel::class.java] = Callable { appViewModelsComponent.provideSignUpViewModel() }
    }
}
package com.plast.app.features.launcher

import android.content.Intent
import android.os.Bundle
import com.plast.app.AppViewModelsFactory
import com.plast.app.baseui.BaseActivity
import com.plast.app.data.local.result.EventObserver
import com.plast.app.features.launcher.viewmodel.LaunchDestination
import com.plast.app.features.launcher.viewmodel.LaunchViewModel
import com.plast.app.features.login.LoginActivity
import com.plast.app.features.main.MainActivity
import com.plast.app.features.onboarding.OnboardingActivity
import viewModelProvider
import javax.inject.Inject

class LauncherActivity : BaseActivity() {

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : LaunchViewModel = viewModelProvider(vmFactory)

            viewModel.launchDestination.observe(this, EventObserver { destination ->
                when (destination) {
                    LaunchDestination.ONBOARDING -> startActivity(Intent(this, LoginActivity::class.java))
                    LaunchDestination.LOGIN -> startActivity(Intent(this, LoginActivity::class.java))
                    LaunchDestination.MAIN_ACTIVITY -> startActivity(Intent(this, MainActivity::class.java))
                }
                this.finish()
            })
    }
}

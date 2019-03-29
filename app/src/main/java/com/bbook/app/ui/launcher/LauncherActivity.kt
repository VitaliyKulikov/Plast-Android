package com.bbook.app.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bbook.app.AppViewModelsFactory
import com.bbook.app.baseui.BaseActivity
import com.bbook.app.data.local.result.EventObserver
import com.bbook.app.ui.launcher.viewmodel.LaunchDestination
import com.bbook.app.ui.launcher.viewmodel.LaunchViewModel
import com.bbook.app.ui.login.LoginActivity
import com.bbook.app.ui.main.MainActivity
import com.bbook.app.ui.onboarding.OnboardingActivity
import javax.inject.Inject

class LauncherActivity : BaseActivity() {

    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, vmFactory).get(LaunchViewModel::class.java)

            viewModel.launchDestination.observe(this, EventObserver { destination ->
                when (destination) {
                    LaunchDestination.ONBOARDING -> startActivity(Intent(this, OnboardingActivity::class.java))
                    LaunchDestination.LOGIN -> startActivity(Intent(this, LoginActivity::class.java))
                    LaunchDestination.MAIN_ACTIVITY -> startActivity(Intent(this, MainActivity::class.java))
                }
                this.finish()
            })

    }
}

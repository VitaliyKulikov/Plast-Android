package com.bbook.app.features.onboarding

import android.os.Bundle
import com.bbook.app.R
import com.bbook.app.baseui.BaseActivity
import com.bbook.app.features.onboarding.fragments.OnBoardingFragment

class OnboardingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        addFragment()
    }
    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragmentContainer,
                OnBoardingFragment.newInstance(),
                OnBoardingFragment.TAG
            )
            .commit()
    }
}

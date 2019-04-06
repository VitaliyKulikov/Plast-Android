package com.plast.app.features.profile

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.profile.fragment.ProfileFragment

class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragmentContainer,
                ProfileFragment.newInstance(),
                ProfileFragment.TAG
            )
            .commit()
    }
}

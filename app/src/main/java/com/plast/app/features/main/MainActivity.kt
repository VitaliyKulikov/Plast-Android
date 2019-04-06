package com.plast.app.features.main

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.main.checklist.fragments.CheckListPagerFragment
import com.plast.app.toolbox.extensions.animationRotate
import com.plast.app.toolbox.extensions.hideWithAnimationAlpha
import com.plast.app.toolbox.extensions.showWithAnimationAlpha
import com.plast.app.features.main.guide.fragments.GuideFragment
import com.plast.app.features.main.home.fragments.HomeFragment
import com.plast.app.features.main.notification.fragments.NotificationFragment
import com.plast.app.features.main.profile.fragments.ProfileFragment
import consume
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.notification_badge.*

class MainActivity : BaseActivity(), View.OnClickListener {
    private var lastSelectedId: Int = R.id.navigation_home
    private lateinit var badge: View
import com.plast.app.features.main.fragments.MainFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragmentContainer,
                MainFragment.newInstance(),
                MainFragment.TAG
            )
            .commit()
    }
}

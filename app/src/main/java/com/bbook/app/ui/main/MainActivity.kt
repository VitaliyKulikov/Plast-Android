package com.bbook.app.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.bbook.app.R
import com.bbook.app.baseui.BaseActivity
import com.bbook.app.extensions.animationRotate
import com.bbook.app.extensions.hideWithAnimationAlpha
import com.bbook.app.extensions.showWithAnimationAlpha
import com.bbook.app.ui.main.guide.fragments.GuideFragment
import com.bbook.app.ui.main.home.fragments.HomeFragment
import com.bbook.app.ui.main.notification.fragments.NotificationFragment
import com.bbook.app.ui.main.profile.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.notification_badge.*

class MainActivity : BaseActivity(), View.OnClickListener {
    private var lastSelectedId: Int = R.id.navigation_home
    private lateinit var badge: View

    override fun onClick(v: View?) {
        when (v) {
            fab -> {
                if (fab.rotation == 0f) {
                    showAction(true)
                } else {
                    showAction(false)
                }
            }
            shadow ->{
                showAction(false)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFirstFragment()
        setListeners()
        addBadge(3)//Add badge to second tab
    }

    private fun setListeners() {
        fab.setOnClickListener(this)
        shadow.setOnClickListener(this)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun addFirstFragment() {
        setFragment(HomeFragment.newInstance(), R.id.navigationFragmentContainer)
        setItemChecked(R.id.navigation_home)
        bottomNavigation.selectedItemId = R.id.navigation_home
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        showAction(false)//hide action when you tapped on menu
        if (it.isChecked) {
            return@OnNavigationItemSelectedListener false
        }
        return@OnNavigationItemSelectedListener when (it.itemId) {
            R.id.navigation_home -> {
                startHomeFragment()
                true
            }
            R.id.navigation_profile -> {
                startProfileFragment()
                true
            }
            R.id.navigation_notification -> {
                startNotificationFragment()
                true
            }
            R.id.navigation_guide -> {
                startGuideFragment()
                true
            }
            else -> false
        }
    }

    private fun startHomeFragment() {
        startFragment(HomeFragment.newInstance(), HomeFragment.TAG)
    }

    private fun startProfileFragment() {
        startFragment(ProfileFragment.newInstance(), ProfileFragment.TAG)
    }

    private fun startGuideFragment() {
        startFragment(GuideFragment.newInstance(), GuideFragment.TAG)
    }

    private fun startNotificationFragment() {
        startFragment(NotificationFragment.newInstance(), NotificationFragment.TAG)
    }

    private fun startFragment(fr: Fragment, tag: String) {
        setFragment(fr, R.id.navigationFragmentContainer)
    }

    private fun setItemChecked(itemId: Int) {
        lastSelectedId = itemId
        (0 until bottomNavigation.menu.size()).forEach {
            val item = bottomNavigation.menu.getItem(it)
            item.isChecked = item.itemId == itemId
        }
    }

    private fun addBadge(position: Int) {
        val bottomMenu = bottomNavigation.getChildAt(0) as? BottomNavigationMenuView
        val bottomNavigationItemView = bottomMenu?.getChildAt(position) as BottomNavigationItemView
        badge = LayoutInflater.from(this).inflate(R.layout.notification_badge, bottomMenu, false)
        val badgeLayout: FrameLayout.LayoutParams = FrameLayout.LayoutParams(badge.layoutParams).apply {
            gravity = Gravity.CENTER_HORIZONTAL
            topMargin = resources.getDimension(R.dimen.spacing_normal).toInt()
            leftMargin = resources.getDimension(R.dimen.bagde_left_margin).toInt()
        }
        bottomNavigationItemView.addView(badge, badgeLayout)
    }

    @SuppressLint("PrivateResource")
    private fun updateBadge(count: Int) {
        if (count > 0) {
            badge.showWithAnimationAlpha()
            if (count > 99) {
                notificationsBadgeTextView.text = this.resources.getString(R.string.plus99)
            } else {
                notificationsBadgeTextView.text = count.toString()
            }
        } else {
            badge.hideWithAnimationAlpha()
        }
    }

    private fun showAction(show: Boolean) {
        if (show) {
            fab.animationRotate(45f)
            shadow.showWithAnimationAlpha()
            actions.showWithAnimationAlpha()
        } else {
            fab.animationRotate(0f)
            shadow.hideWithAnimationAlpha()
            actions.hideWithAnimationAlpha()
        }
    }
}

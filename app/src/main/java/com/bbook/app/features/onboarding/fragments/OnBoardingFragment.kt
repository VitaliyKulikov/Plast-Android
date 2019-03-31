package com.bbook.app.features.onboarding.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.bbook.app.AppViewModelsFactory
import com.bbook.app.R
import com.bbook.app.baseui.BaseFragment
import com.bbook.app.features.onboarding.fragments.pages.OnboardingPageAdapter
import com.bbook.app.features.onboarding.viewmodel.OnBoardViewModel
import javax.inject.Inject

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.bbook.app.toolbox.extensions.hideWithAnimationAlpha
import com.bbook.app.toolbox.extensions.showWithAnimationAlpha
import com.bbook.app.features.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_on_boarding.*

class OnBoardingFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: OnBoardViewModel

    companion object {
        val TAG = OnBoardingFragment::class.java.simpleName
        fun newInstance() = OnBoardingFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_on_boarding

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun setListeners() {
        skip.setOnClickListener(this)
        sign_in.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            skip -> {
                startLoginActivity()
            }
            sign_in -> {
                startLoginActivity()
            }
        }
    }

    private fun startLoginActivity() {
        viewModel.setOnboardingDone()
        startActivity(Intent(activity, LoginActivity::class.java))
        activity?.finish()
    }

    override fun initViewModel() {
        viewModel = ViewModelProviders.of(this, vmFactory).get(OnBoardViewModel::class.java)
        viewModel.onboardingLiveData.observe(this, Observer { introList ->
            fragmentManager?.let {
                container.showWithAnimationAlpha()
                pager.adapter = OnboardingPageAdapter(it, introList)
                pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {}
                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
                    override fun onPageSelected(position: Int) {
                        if (position == 2) {
                            skip.hideWithAnimationAlpha()
                            sign_in.showWithAnimationAlpha()
                        } else {
                            skip.showWithAnimationAlpha()
                            sign_in.hideWithAnimationAlpha()
                        }
                    }
                })
                dots_indicator.setViewPager(pager)
            }
        })
    }
}

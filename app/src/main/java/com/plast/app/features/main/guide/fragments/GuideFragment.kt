package com.plast.app.features.main.guide.fragments

import android.os.Bundle
import android.view.View
import com.plast.app.R
import com.plast.app.baseui.BaseFragment

class GuideFragment : BaseFragment() {

    companion object {
        val TAG = GuideFragment::class.java.simpleName
        fun newInstance() = GuideFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_guide

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
    }
}

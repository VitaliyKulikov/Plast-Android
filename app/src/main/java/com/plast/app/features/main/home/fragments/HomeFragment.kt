package com.plast.app.features.main.home.fragments

import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.guide.viewmodel.GuideViewModel
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun setListeners() {

    }

    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: GuideViewModel

    override fun layoutId(): Int = R.layout.fragment_guiede

    override fun onViewReady(inflatedView: View, args: Bundle?) {

    }

    override fun initViewModel() {

    }
}

package com.bbook.app.ui.main.home.fragments

import android.os.Bundle
import android.view.View
import com.bbook.app.AppViewModelsFactory
import com.bbook.app.R
import com.bbook.app.baseui.BaseFragment
import com.bbook.app.ui.main.guide.viewmodel.GuideViewModel
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

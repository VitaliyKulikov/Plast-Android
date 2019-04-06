package com.plast.app.features.main.checklist.fragments

import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.guide.viewmodel.GuideViewModel
import javax.inject.Inject

class CheckListPagerFragment : BaseFragment() {

    companion object {
        val TAG = CheckListPagerFragment::class.java.simpleName
        fun newInstance() = CheckListPagerFragment()
    }

    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    private lateinit var viewModel: GuideViewModel

    override fun layoutId(): Int = R.layout.fragment_checklist_pager

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
    }
}

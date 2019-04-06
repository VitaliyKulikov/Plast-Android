package com.plast.app.features.main.fragments

import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment(),View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    companion object {
        val TAG = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_main

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun initViewModel() {

    }

    override fun setListeners() {

    }

    override fun onClick(v: View?) {

    }


}
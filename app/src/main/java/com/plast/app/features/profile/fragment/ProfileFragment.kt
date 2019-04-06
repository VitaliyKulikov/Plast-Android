package com.plast.app.features.profile.fragment


import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import javax.inject.Inject

class ProfileFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory
    //private lateinit var viewModel: LoginViewModel

    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun initViewModel() {
//        viewModel = ViewModelProviders
//            .of(this, vmFactory)
//            .get(LoginViewModel::class.java)
    }

    override fun setListeners() {

    }

    override fun onClick(v: View?) {

    }
}
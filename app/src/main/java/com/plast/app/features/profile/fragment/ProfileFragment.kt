package com.plast.app.features.profile.fragment


import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import javax.inject.Inject
import android.view.Menu
import com.plast.app.ToolbarFragment
import consume
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : ToolbarFragment(), View.OnClickListener {
    override fun setToolbar() {
        toolbar.inflateMenu(R.menu.profile_navigation)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.navigation_close -> consume{ activity?.finish() }
                else -> { false }
            }
        }
    }

    @Inject
    lateinit var vmFactory: AppViewModelsFactory


    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        setHasOptionsMenu(true)
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

     fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main_menu, menu)
        return true
    }
}
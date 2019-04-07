package com.plast.app.features.profile.fragment


import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import javax.inject.Inject
import androidx.lifecycle.Observer
import com.plast.app.ToolbarFragment
import com.plast.app.features.profile.viewmodel.ProfileViewModel
import com.plast.app.toolbox.extensions.loadWithGlideCircleCrop
import consume
import kotlinx.android.synthetic.main.fragment_profile.*
import viewModelProvider


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

    private lateinit var viewModel: ProfileViewModel


    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_profile

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        setHasOptionsMenu(true)
    }

    override fun initViewModel() {
        viewModel = viewModelProvider(vmFactory)
        viewModel.userLiveData.observe(this, Observer {
            tvName.text = it.name
            ivProfileAvatar.loadWithGlideCircleCrop(it.avatarUrl,R.drawable.ic_place_holder_circle)

        })
    }

    override fun setListeners() {

    }

    override fun onClick(v: View?) {

    }
}
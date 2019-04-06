package com.plast.app.features.main.profile.fragments

import android.os.Bundle
import android.view.View
import com.plast.app.R
import com.plast.app.ToolbarFragment
import com.plast.app.toolbox.extensions.loadWithGlideCircleCrop
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.include_profile_main.*

class ProfileFragment : ToolbarFragment() {
    companion object {
        val TAG = ProfileFragment::class.java.simpleName
        fun newInstance() = ProfileFragment()
    }

    override fun layoutId(): Int = com.plast.app.R.layout.fragment_profile

    override fun setToolbar() {
        toolbar.inflateMenu(R.menu.profile_navigation)
    }

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        setData()
    }

    private fun setData() {
        profile_photo.loadWithGlideCircleCrop(
            "https://i.pinimg.com/originals/ce/10/84/ce1084ba5e7d8342b59e347f2684d99f.jpg",
            R.drawable.fab_ripple
        )
    }

    override fun initViewModel() {

    }

    override fun setListeners() {

    }

}

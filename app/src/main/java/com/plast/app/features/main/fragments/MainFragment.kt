package com.plast.app.features.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.viewmodel.MainViewModel
import com.plast.app.features.profile.ProfileActivity
import com.plast.app.toolbox.extensions.loadWithGlideCircleCrop
import kotlinx.android.synthetic.main.fragment_main.*
import viewModelProvider
import javax.inject.Inject

class MainFragment : BaseFragment(), View.OnClickListener {
    @Inject
    lateinit var vmFactory: AppViewModelsFactory

    companion object {
        val TAG = MainFragment::class.java.simpleName
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun layoutId(): Int = R.layout.fragment_main

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        vpMain.adapter = MainViewPagerAdapter(childFragmentManager)
        setData()//todo add to observer
    }

    override fun initViewModel() {
        viewModel = viewModelProvider(vmFactory)
    }

    override fun setListeners() {
    ivAvatar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            ivAvatar -> {
                startActivity(Intent(activity, ProfileActivity::class.java))
            }
        }
    }

    fun setData(){
        ivAvatar.loadWithGlideCircleCrop("https://www.plast.org.ua/wp-content/uploads/2018/11/27459346_1897069087001526_6810170692466779901_n.jpg",R.drawable.ic_place_holder_circle)
    }


}
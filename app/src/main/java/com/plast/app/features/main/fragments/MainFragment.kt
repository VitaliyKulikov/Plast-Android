package com.plast.app.features.main.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.plast.app.AppViewModelsFactory
import com.plast.app.R
import com.plast.app.baseui.BaseFragment
import com.plast.app.features.main.checklist.fragments.CardFragment
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
        const val COUNT_OF_PAGES = 12 // start 0

        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun layoutId(): Int = R.layout.fragment_main

    override fun onViewReady(inflatedView: View, args: Bundle?) {
        vpMain.adapter = MainViewPagerAdapter(childFragmentManager).apply { pages = initPages() }
        setData()//todo add to observer
    }

    override fun initViewModel() {
        viewModel = viewModelProvider(vmFactory)
        viewModel.userLiveData.observe(this, Observer {
            ivAvatar.loadWithGlideCircleCrop(it.avatarUrl,R.drawable.ic_place_holder_circle)
            tvUserName.text = it.name
        })
    }

    override fun setListeners() {
        ivAvatar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            ivAvatar -> startActivity(Intent(activity, ProfileActivity::class.java))
        }
    }

    private fun initPages() = ArrayList<Fragment>().apply {
        for (position in 0..COUNT_OF_PAGES) {
            add(CardFragment.newInstance(position))
        }
    }

    private fun setData() {
        ivAvatar.loadWithGlideCircleCrop("https://www.plast.org.ua/wp-content/uploads/2018/11/27459346_1897069087001526_6810170692466779901_n.jpg", R.drawable.ic_place_holder_circle)
    }
}

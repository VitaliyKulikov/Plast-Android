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
        viewModel.coinsLiveData.observe(this, Observer { coins ->
            coins?.let {
                tvCoins.text = resources.getString(R.string.formatter_coins, coins)
            }
        })
        viewModel.currentStepLiveData.observe(this, Observer { currentStep ->
            currentStep?.let {
                stepAdapter(currentStep)
            }
        })
    }

    private fun stepAdapter(step:Int){

        //I didn't have time for this ¯\_(ツ)_/¯
        if (step >= 1) check1.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 2) check2.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 3) check3.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 4) check4.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 5) check5.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 6) check6.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 7) check7.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 8) check8.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 9) check9.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 10) check10.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 11) check11.background = context?.getDrawable(R.drawable.shape_circle_accent)
        if (step >= 11) check12.background = context?.getDrawable(R.drawable.shape_circle_accent)
    }

    override fun setListeners() {

    }

    override fun onClick(v: View?) {

    }
}
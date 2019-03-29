package com.bbook.app.ui.onboarding.fragments.pages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bbook.app.models.IntroModel
import android.os.Bundle
import com.bbook.app.R

class OnboardingPageAdapter(
    fm: FragmentManager,
    private val introList: List<IntroModel>
) : FragmentPagerAdapter(fm) {

    private fun getFragment(position:Int):Fragment{
        val bundle = Bundle()
        bundle.putString("title", introList[position].title)
        bundle.putString("description", introList[position].description)
        val artId = when(position){
            0 -> R.drawable.ill_intro_1
            1 -> R.drawable.ill_intro_2
            2 -> R.drawable.ill_intro_3
            else -> R.drawable.ill_intro_1
        }
        bundle.putInt("img_id", artId)

        val numberImgId = when(position){
            0 -> R.drawable.ill_1
            1 -> R.drawable.ill_2
            2 -> R.drawable.ill_3
            else -> R.drawable.ill_intro_1
        }
        bundle.putInt("img_number_id", numberImgId)

        val fragment2 = OnBoardingPage()
        fragment2.arguments = bundle
        return fragment2
    }

    override fun getCount(): Int = introList.size

    override fun getItem(position: Int): Fragment = getFragment(position)
}
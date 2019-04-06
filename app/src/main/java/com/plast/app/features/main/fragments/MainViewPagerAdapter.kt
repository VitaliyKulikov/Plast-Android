package com.plast.app.features.main.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.plast.app.features.signup.fragments.SignUpFragment

class MainViewPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    private val pagesList = listOf<Fragment>(
        SignUpFragment(),
        SignUpFragment(),
        SignUpFragment(),
        SignUpFragment()
    )

    override fun getItem(position: Int): Fragment  = pagesList[position]

    override fun getCount(): Int = pagesList.size

}
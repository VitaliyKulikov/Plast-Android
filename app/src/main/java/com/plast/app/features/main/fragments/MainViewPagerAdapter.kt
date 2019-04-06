package com.plast.app.features.main.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var pages = emptyList<Fragment>()

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount(): Int = pages.size

}

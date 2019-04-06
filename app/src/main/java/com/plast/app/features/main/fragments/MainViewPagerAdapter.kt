package com.plast.app.features.main.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.plast.app.features.main.checklist.fragments.CheckListPagerFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val pagesList = listOf<Fragment>(
            CheckListPagerFragment(),
            CheckListPagerFragment(),
            CheckListPagerFragment(),
            CheckListPagerFragment()
    )

    override fun getItem(position: Int): Fragment = pagesList[position]

    override fun getCount(): Int = pagesList.size

}
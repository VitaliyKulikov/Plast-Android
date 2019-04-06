package com.plast.app.baseui

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
        dispatchingAndroidInjector

    protected fun setFragment(fragment: Fragment, containerId: Int) {
        val newFrag = supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if (newFrag != null && newFrag.isVisible) {
            return /* do nothing, already here */
        } else {
            replaceFragment(containerId, fragment, (fragment.javaClass.simpleName))
        }
    }


    protected fun addFragmentWithBackStack(fragment: Fragment, containerId: Int){
        val newFrag = supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if (newFrag != null && newFrag.isVisible) {
            return /* do nothing, already here */
        } else {
            replaceFragmentWithBackStack(containerId, fragment, (fragment.javaClass.simpleName))
        }
    }

    private fun replaceFragmentWithBackStack(@IdRes id: Int, frag: Fragment, tag: String? = frag.javaClass.simpleName) {
        supportFragmentManager.beginTransaction().replace(id, frag, tag).addToBackStack(tag).commitAllowingStateLoss()
    }
    private fun replaceFragment(@IdRes id: Int, frag: Fragment, tag: String? = frag.javaClass.simpleName){
        supportFragmentManager.beginTransaction().replace(id, frag, tag).commitAllowingStateLoss()
    }
}
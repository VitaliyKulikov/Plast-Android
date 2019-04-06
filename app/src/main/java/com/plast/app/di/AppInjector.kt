package com.plast.app.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.plast.app.BaseApplication
import com.plast.app.baseui.Injectable

import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

fun initInjections(app: BaseApplication): AppComponent {

    val appComponent = DaggerAppComponent.builder().application(app).build().also { it.inject(app) }
    val callback = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {}
        override fun onActivityResumed(activity: Activity?) {}
        override fun onActivityStarted(activity: Activity?) {}
        override fun onActivityDestroyed(activity: Activity?) {}
        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}
        override fun onActivityStopped(activity: Activity?) {}
        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            handleActivity(activity)
        }
    }
    app.registerActivityLifecycleCallbacks(callback)
    return appComponent
}

private fun handleActivity(activity: Activity?) {
    if (activity is HasSupportFragmentInjector) {
        AndroidInjection.inject(activity)
    }
    if (activity is FragmentActivity) {
        val callback = object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                super.onFragmentCreated(fm, f, savedInstanceState)
                if (f is Injectable) {
                    AndroidSupportInjection.inject(f)
                }
            }
        }
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(callback, true)
    }
}
package com.plast.app

import android.app.Activity
import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp
import com.plast.app.di.AppComponent
import com.plast.app.di.initInjections
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var instance: BaseApplication
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        instance = this
        appComponent = initInjections(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingInjector

    fun getInstance(): BaseApplication {
        return instance
    }
}

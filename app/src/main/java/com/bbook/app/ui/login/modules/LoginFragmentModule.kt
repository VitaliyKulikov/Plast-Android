package com.bbook.app.ui.login.modules

import com.bbook.app.ui.login.fragments.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFragment(): LoginFragment
}
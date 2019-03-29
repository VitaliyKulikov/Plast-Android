package com.bbook.app.ui.signup.modules

import com.bbook.app.ui.signup.fragments.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignUpFragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFragment(): SignUpFragment
}
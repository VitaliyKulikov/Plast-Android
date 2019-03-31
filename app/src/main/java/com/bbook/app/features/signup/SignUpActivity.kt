package com.bbook.app.features.signup

import android.os.Bundle
import com.bbook.app.R
import com.bbook.app.baseui.BaseActivity
import com.bbook.app.features.signup.fragments.SignUpFragment

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        addFragment()
    }
    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragmentContainer,
                SignUpFragment.newInstance(),
                SignUpFragment.TAG
            )
            .commit()
    }
}
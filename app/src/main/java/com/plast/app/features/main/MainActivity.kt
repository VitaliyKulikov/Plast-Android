package com.plast.app.features.main

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.main.fragments.MainFragment

class MainActivity : BaseActivity() {

    class MainActivity : BaseActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            addFragment()
        }

        private fun addFragment() {
            supportFragmentManager.beginTransaction()
                    .add(
                            R.id.fragmentContainer,
                            MainFragment.newInstance(),
                            MainFragment.TAG
                    )
                    .commit()
        }
    }
}

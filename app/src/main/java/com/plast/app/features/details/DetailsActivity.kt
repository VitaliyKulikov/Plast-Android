package com.plast.app.features.details

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.details.fragments.DetailsFragment

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,
                DetailsFragment.newInstance(),
                DetailsFragment.TAG
            ).commit()
    }
}

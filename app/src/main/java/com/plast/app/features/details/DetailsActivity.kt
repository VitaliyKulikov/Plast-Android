package com.plast.app.features.details

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.details.fragments.DetailsFragment

class DetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        addFragment(intent.getBundleExtra("cardFragment"))
    }

    private fun addFragment(bundle: Bundle) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer,
                DetailsFragment.newInstance(bundle),
                DetailsFragment.TAG
            ).commit()
    }
}

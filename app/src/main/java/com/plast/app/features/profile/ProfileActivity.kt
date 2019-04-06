package com.plast.app.features.profile

import android.os.Bundle
import com.plast.app.R
import com.plast.app.baseui.BaseActivity
import com.plast.app.features.profile.fragment.ProfileFragment
import com.google.firebase.database.FirebaseDatabase



class ProfileActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        addFragment()
    }

    private fun addFragment() {
        // Write a message to the database

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragmentContainer,
                ProfileFragment.newInstance(),
                ProfileFragment.TAG
            )
            .commit()
    }
}

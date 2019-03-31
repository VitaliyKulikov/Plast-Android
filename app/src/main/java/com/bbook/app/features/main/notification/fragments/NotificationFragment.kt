package com.bbook.app.features.main.notification.fragments

import android.os.Bundle
import android.view.View
import com.bbook.app.R
import com.bbook.app.baseui.BaseFragment

class NotificationFragment : BaseFragment() {
    companion object {
        val TAG = NotificationFragment::class.java.simpleName
        fun newInstance() = NotificationFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_notification

    override fun onViewReady(inflatedView: View, args: Bundle?) {
    }

    override fun initViewModel() {
    }

    override fun setListeners() {
    }
}

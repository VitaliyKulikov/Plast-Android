package com.plast.app

import android.os.Bundle
import com.plast.app.baseui.BaseFragment

abstract class ToolbarFragment: BaseFragment() {

    abstract fun setToolbar()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbar()
    }
}
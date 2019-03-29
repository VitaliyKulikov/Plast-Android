package com.bbook.app

import android.os.Bundle
import com.bbook.app.baseui.BaseFragment

abstract class ToolbarFragment: BaseFragment() {

    abstract fun setToolbar()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbar()
    }
}
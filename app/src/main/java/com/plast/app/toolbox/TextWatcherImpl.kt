package com.plast.app.toolbox

import android.text.TextWatcher

interface TextWatcherImpl : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //default implementation
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //default implementation
    }
}

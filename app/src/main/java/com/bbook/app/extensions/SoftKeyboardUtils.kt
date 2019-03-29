package com.bbook.app.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Activity.showKeyboard(target: View) {
    val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    keyboard.showSoftInput(target, 0)
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    hideKeyboard(view)
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard(null)
}

fun Activity.hideKeyboard(target: View?) {
    val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    target?.let {
        keyboard.hideSoftInputFromWindow(target.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
    } ?: let {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
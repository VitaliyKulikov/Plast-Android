package com.plast.app.toolbox.extensions

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
    safeLet(context, view) { context, view ->
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    } ?: let {
        activity?.hideKeyboard()
    }
}

fun Activity.hideKeyboard(target: View?) {
    target?.let {
        target.postDelayed(Runnable {
            val keyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(target.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }, 2000)
    } ?: let {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
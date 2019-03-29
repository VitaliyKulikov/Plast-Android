package com.bbook.app.extensions

import android.content.res.Resources

val kotlin.Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val kotlin.Float.dp: Float
    get() = (this * Resources.getSystem().displayMetrics.density)
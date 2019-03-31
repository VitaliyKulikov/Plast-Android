package com.bbook.app.toolbox.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson<T>(json, object : TypeToken<T>() {}.type)!!
}

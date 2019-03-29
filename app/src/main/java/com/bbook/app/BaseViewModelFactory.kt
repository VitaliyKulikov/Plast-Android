package com.bbook.app

import androidx.collection.ArrayMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.concurrent.Callable

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelFactory : ViewModelProvider.Factory {

    private val creators: ArrayMap<Class<*>, Callable<out ViewModel>> = ArrayMap()
    private var isAdded = false

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        provideAdding()
        var creator = creators[modelClass]
        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }

            if (creator == null) {
                throw IllegalArgumentException("Unknown model class " + modelClass)
            }
        }

        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun provideAdding() {
        if (isAdded)return
        fillViewModels(creators)
        isAdded = true
    }

    abstract fun fillViewModels(creators: ArrayMap<Class<*>, Callable<out ViewModel>>)
}
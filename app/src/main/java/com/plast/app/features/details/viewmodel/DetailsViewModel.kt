package com.plast.app.features.details.viewmodel

import androidx.lifecycle.ViewModel
import com.plast.app.data.local.sharedpreferences.SyncSharedPreferences
import javax.inject.Inject

class DetailsViewModel @Inject constructor (
    private val sharedPreferences: SyncSharedPreferences
) : ViewModel() {

    private var currentUserCheckPoint: Int

    init {
        currentUserCheckPoint = sharedPreferences.getCurrentUserCheckPoint()
    }

    fun unlockNextStep() {
        currentUserCheckPoint++

        sharedPreferences.setCurrentUserCheckPoint(currentUserCheckPoint)
    }
}
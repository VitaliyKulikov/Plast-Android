package com.plast.app.features.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.data.local.database.entity.CardEntity
import com.plast.app.repositories.CardRepository
import javax.inject.Inject

class DetailsViewModel @Inject constructor (
    private val cardRepository: CardRepository
) : ViewModel() {

    val cardLiveData by lazy { MutableLiveData<CardEntity>() }

    fun loadDataByCardIdFromRepository(cardId: Int) {

        cardLiveData.value = cardRepository.getCardItem(cardId)
    }
}
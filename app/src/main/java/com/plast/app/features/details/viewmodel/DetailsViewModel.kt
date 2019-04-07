package com.plast.app.features.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.models.CardModel
import com.plast.app.repositories.CardRepository
import javax.inject.Inject

class DetailsViewModel @Inject constructor (
    private val cardRepository: CardRepository
) : ViewModel() {

    val cardLiveData by lazy { MutableLiveData<CardModel>() }

    fun loadDataByCardIdFromRepository(cardId: Int) {

        cardRepository.getCardItem(cardId) { card ->
            cardLiveData.value = card
        }
    }
}
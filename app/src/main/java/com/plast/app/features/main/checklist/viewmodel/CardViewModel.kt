package com.plast.app.features.main.checklist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.models.CardModel
import com.plast.app.repositories.CardRepository
import javax.inject.Inject

class CardViewModel
@Inject constructor(
        private val repo: CardRepository
) : ViewModel() {

    var cardPosition: Int = -1

    private val _cardLiveData by lazy { MutableLiveData<CardModel>() }
    val cardLiveData: LiveData<CardModel>
        get() {
            repo.getCardItem(cardPosition) {
                _cardLiveData.postValue(it)
            }
            return _cardLiveData
        }
}

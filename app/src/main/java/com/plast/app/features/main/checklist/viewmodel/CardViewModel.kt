package com.plast.app.features.main.checklist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.models.CURRENT
import com.plast.app.models.CardModel
import com.plast.app.models.DONE
import com.plast.app.models.LOCKED
import com.plast.app.repositories.CardRepository
import javax.inject.Inject

class CardViewModel
@Inject constructor(
        private val repo: CardRepository
) : ViewModel() {

    var cardPosition: Int = -1
    var currentUserCheckPoint: Int = -1

    private val _cardLiveData by lazy { MutableLiveData<CardModel>() }
    val cardLiveData: LiveData<CardModel>
        get() {
            repo.getCardItem(cardPosition) {
                val cardModel = updateUserCheckPoint(it)
                _cardLiveData.postValue(cardModel)
            }
            return _cardLiveData
        }

    private fun updateUserCheckPoint(cm: CardModel): CardModel {
        val cardState = when {
            cm.cardPos < currentUserCheckPoint -> DONE
            cm.cardPos == currentUserCheckPoint -> CURRENT
            else -> LOCKED
        }

        return cm.apply { this.cardState = cardState }
    }
}

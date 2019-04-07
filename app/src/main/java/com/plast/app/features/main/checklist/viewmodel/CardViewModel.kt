package com.plast.app.features.main.checklist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.plast.app.data.local.database.entity.CURRENT
import com.plast.app.data.local.database.entity.CardEntity
import com.plast.app.data.local.database.entity.DONE
import com.plast.app.data.local.database.entity.LOCKED
import com.plast.app.repositories.CardRepository
import javax.inject.Inject

class CardViewModel
@Inject constructor(
        private val repo: CardRepository
) : ViewModel() {

    var cardPosition: Int = -1
    var currentUserCheckPoint: Int = -1

    val cardDao by lazy { MutableLiveData<CardEntity>() }

    lateinit var mCurrentCardEntity: CardEntity

    private val _cardLiveData by lazy { MutableLiveData<CardEntity>() }
    val cardLiveData: LiveData<CardEntity>
        get() {
            repo.getCardItem(cardPosition).let {
                mCurrentCardEntity = updateUserCheckPoint(it)
                repo.insertCardEntity(mCurrentCardEntity)
                _cardLiveData.postValue(mCurrentCardEntity)
            }
            //getItems()
            return _cardLiveData
        }

    fun getItems(){
        val a = repo.getCardLiveData().value
        val b = a
    }
    private fun updateUserCheckPoint(cm: CardEntity): CardEntity {
        val cardState = when {
            cm.cardPos < currentUserCheckPoint -> DONE
            cm.cardPos == currentUserCheckPoint -> CURRENT
            else -> LOCKED
        }

        return cm.apply { this.cardState = cardState }
    }
}

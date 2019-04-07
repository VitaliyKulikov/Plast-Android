package com.plast.app.repositories

import androidx.lifecycle.LiveData
import com.plast.app.AppExecutors
import com.plast.app.R
import com.plast.app.data.local.AppDatabase
import com.plast.app.data.local.database.entity.CardEntity
import com.plast.app.data.local.sharedpreferences.SyncSharedPreferences
import java.util.*
import javax.inject.Inject

class CardRepository
@Inject constructor(
        private val appDatabase: AppDatabase,
        private val appExecutors: AppExecutors,
        private val sharedPreferences: SyncSharedPreferences) {
    private var cardList = emptyList<CardEntity>()

    init {
        cardList = initCardList()
    }

    fun getCardItem(cardPosition: Int): CardEntity {
        return cardList[cardPosition]
    }
    fun getCardLiveData(): LiveData<List<CardEntity>> {
        return appDatabase.cardDao().getAllCards()
    }

    fun insertCardEntity(mCurrentCardEntity: CardEntity) {
        appExecutors.ioExecutor.execute {
            appDatabase.runInTransaction {
                try {
                    appDatabase.cardDao().insertData(mCurrentCardEntity)
                } catch (ex: ConcurrentModificationException) {
                    ex.printStackTrace()
                }
            }
        }
    }

    private fun initCardList(): ArrayList<CardEntity> {
        val listOfCard = arrayListOf<CardEntity>()
        listOfCard.add(CardEntity(0, 10, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(1, 20, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(2, 30, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(3, 40, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(4, 50, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(5, 60, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(6, 70, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(7, 80, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(8, 90, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(9, 100, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(10, 110, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(11, 120, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        listOfCard.add(CardEntity(12, 130, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        return listOfCard
    }
}

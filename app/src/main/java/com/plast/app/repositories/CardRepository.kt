package com.plast.app.repositories

import com.plast.app.R
import com.plast.app.data.local.database.entity.CardEntity

class CardRepository {
    private var cardList = emptyList<CardEntity>()

    init {
        initCardList()
    }

    fun getCardItem(cardPosition: Int) = cardList[cardPosition]

    private fun initCardList() {
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
        cardList = listOfCard
    }
}

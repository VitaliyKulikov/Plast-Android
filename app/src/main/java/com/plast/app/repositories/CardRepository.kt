package com.plast.app.repositories

import com.plast.app.R
import com.plast.app.models.CardModel

class CardRepository {

    private lateinit var cardList: List<CardModel>

    init {
        initCardList()
    }

    fun getCardItem(cardPosition: Int, onSuccess: (cardModel: CardModel) -> Unit) {
        onSuccess(cardList[cardPosition])
    }

    private fun initCardList() {
        cardList = arrayListOf<CardModel>().apply {
            add(CardModel(1, 10, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(2, 20, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(3, 30, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(4, 40, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(5, 50, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(6, 60, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(7, 70, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(8, 80, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(9, 90, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(10, 100, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(11, 110, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(12, 120, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
            add(CardModel(13, 130, R.drawable.ill_step_one, R.string.title_text, R.string.description_text))
        }
    }
}

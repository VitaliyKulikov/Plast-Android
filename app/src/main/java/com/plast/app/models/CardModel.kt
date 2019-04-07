package com.plast.app.models

class CardModel(
        val cardPos: Int,
        val plastCoin: Int,
        val imageRes: Int,
        val titleResId: Int,
        val descriptionResId: Int
) {
    var cardState: Int = -1
}

const val DONE = 1
const val CURRENT = 2
const val LOCKED = 3
package com.plast.app.data.local.database.entity

data class CardEntity(
        val cardPos: Int,
        val plastCoin: Int,
        val imageRes: Int,
        val titleResId: Int,
        val descriptionResId: Int,
        var cardState: Int = -1
)

const val DONE = 1
const val CURRENT = 2
const val LOCKED = 3
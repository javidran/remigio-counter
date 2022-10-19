package com.dran.remigiocounter.viewmodels

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.dran.remigiocounter.datasource.Card

class CardModelView : ViewModel() {
    private var _cardList = getCards().toMutableStateList()

    val cardList: List<Card>
        get() = _cardList

    fun totalCount() : Int {
        var total = 0
        _cardList.forEach { card -> total += card.points }
        return total
    }

    fun onCountIncrement(index: Int) {
        if(_cardList[index].count < MAX_COUNT) {
            _cardList[index] = _cardList[index].copy(count = _cardList[index].count + 1)
        }
    }

    fun onCountDecrement(index: Int) {
        if(_cardList[index].count > MIN_COUNT) {
            _cardList[index] = _cardList[index].copy(count = _cardList[index].count - 1)
        }
    }

    fun onCountReset() {
        _cardList.clear()
        _cardList.addAll(getCards())
    }
}

private fun getCards() : List<Card> {
    return List(12) { i -> Card(i + 1) }
}

private const val MIN_COUNT = 0
private const val MAX_COUNT = 8
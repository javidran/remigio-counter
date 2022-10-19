package com.dran.remigiocounter.datasource

data class Card(val number: Int, var count: Int = 0) {
    val points: Int = if (number == 1) {
        11 * count
    } else if (number < 10) {
        number * count
    } else {
        10 * count
    }
}

package com.milesq.guess_who.model

enum class TourNumber(val value: String) {
    UNLIMITED("Brak limitu"),
    ONE("1"),
    TWO("2"),
    FIVE("5"),
    TEN("10");

    companion object {
        fun fromValue(value: String): TourNumber? = values().find { it.value == value }
    }
}

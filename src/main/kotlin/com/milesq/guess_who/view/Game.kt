package com.milesq.guess_who.view

import com.milesq.guess_who.model.TourNumber
import tornadofx.*

class Game: View() {
    val tourNumber: TourNumber by param()
    val possibleShowingTypes: List<String> by param()

    override val root = vbox {
        label("Gra")
    }

    init {
        println(tourNumber.value)
        possibleShowingTypes.forEach(::println)
    }
}

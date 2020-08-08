package com.milesq.guess_who.view

import com.milesq.guess_who.app.Styles
import com.milesq.guess_who.model.TourNumber
import com.milesq.guess_who.model.readShowingWays
import javafx.beans.property.*
import javafx.scene.text.FontWeight
import tornadofx.*

class Menu: View("Zgadnij kto to") {
    private val selectedTourNumber = SimpleStringProperty(TourNumber.UNLIMITED.value)
    private val possibleWays = readShowingWays().map {
        Pair(it, SimpleBooleanProperty(true))
    }

    override val root = vbox {
        addClass(Styles.viewContainer)

        val startGame: () -> Unit = {
            val selectedTourNumber = TourNumber.fromValue((selectedTourNumber.value))
            val selectedShowingTypes = possibleWays.filter { it.second.value }.map { it.first }

            val params = mapOf(
                Game::tourNumber to selectedTourNumber,
                Game::possibleShowingTypes to selectedShowingTypes
            )

            val gameViewInstance = find<Game>(params)
            replaceWith(gameViewInstance)
        }

        shortcut("Enter", startGame)

        vbox(50) {
            vbox {
                addClass(Styles.bordered)

                for (possibility in possibleWays) {
                    checkbox(possibility.first, possibility.second)
                }

                separator {
                    vboxConstraints {
                        marginTop = 10.0
                    }
                    prefHeight = 3.0
                }

                label("Liczba tur") {
                    style {
                        fontWeight = FontWeight.SEMI_BOLD
                        fontSize = 20.px
                    }
                }

                val possibleTourNumber = listOf(
                    TourNumber.UNLIMITED,
                    TourNumber.ONE,
                    TourNumber.TWO,
                    TourNumber.FIVE,
                    TourNumber.TEN,
                )

                combobox(selectedTourNumber, possibleTourNumber.map { it.value })
            }

            button("Zacznij") {
                vboxConstraints { marginTop = 60.0 }
                addClass(Styles.linkButton, Styles.linkNavButton)
                action(startGame)
            }
        }
    }
}

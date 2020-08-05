package com.milesq.guess_who.view

import com.milesq.guess_who.app.Game
import com.milesq.guess_who.app.Styles
import com.milesq.guess_who.model.TourNumber
import javafx.beans.property.*
import javafx.scene.text.FontWeight
import tornadofx.*

class MenuView: View("Zgadnij kto to") {
    override val root = vbox {
        addClass(Styles.viewContainer)

        borderpane {
            left<GameProperties>()
            right<GameController>()
        }
    }

    class GameProperties: View() {
        val selectedTourNumber = SimpleStringProperty(TourNumber.UNLIMITED.value)
        val possibleWays = listOf(
            Pair("Pokazywanie bez mówienia", SimpleBooleanProperty(true)),
            Pair("Omówienie", SimpleBooleanProperty(true)),
            Pair("Rysunek", SimpleBooleanProperty(true))
        )

        override val root = vbox {
            style {
                borderColor += box(c("#a1a1a1"))
                borderWidth += box(1.px)
                padding = box(35.px, 20.px)
            }

            for (possibility in possibleWays) {
                checkbox(possibility.first, possibility.second)
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
    }

    class GameController : View() {
        private val menu: MenuView by inject()
        private val gameProperties: GameProperties by inject()

        override val root = vbox {
            button("Edycja Postaci") {
                vboxConstraints { marginTop = 30.0 }
                addClass(Styles.linkButton, Styles.linkNavButton)
                action { menu.replaceWith<Settings>() }
            }

            button("Zacznij") {
                vboxConstraints { marginTop = 60.0 }
                addClass(Styles.linkButton, Styles.linkNavButton)
                action {
                    val selectedTourNumber = TourNumber.fromValue((gameProperties.selectedTourNumber.value))
                    val selectedShowingTypes = gameProperties.possibleWays.filter { it.second.value }.map { it.first }

                    val params = mapOf(
                        Game::tourNumber to selectedTourNumber,
                        Game::possibleShowingTypes to selectedShowingTypes
                    )

                    val gameViewInstance = find<Game>(params)
                    menu.replaceWith(gameViewInstance)
                }
            }
        }
    }
}

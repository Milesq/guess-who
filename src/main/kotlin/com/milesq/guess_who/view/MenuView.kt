package com.milesq.guess_who.view

import com.milesq.guess_who.app.Styles
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
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
        lateinit var selectedTourNumber: SimpleStringProperty

        override val root = vbox {
            val possibleWays = listOf("Pokazywanie bez mówienia", "Omówienie", "Rysunek")
            style {
                borderColor += box(c("#a1a1a1"))
                borderWidth += box(1.px)
                padding = box(35.px, 20.px)
            }

            for (possibility in possibleWays) {
                checkbox(possibility)
            }

            label("Liczba tur") {
                style {
                    fontWeight = FontWeight.SEMI_BOLD
                    fontSize = 20.px
                }
            }

            val texasCities = FXCollections.observableArrayList("Nielimitowane", "1", "2", "5", "10")

            selectedTourNumber = SimpleStringProperty()

            combobox(selectedTourNumber, texasCities)
        }
    }

    class GameController : View() {
        override val root = vbox() {
            button("Edycja Postaci") {
                addClass(Styles.linkButton, Styles.linkNavButton)
            }

            button("Zacznij") {
                addClass(Styles.linkButton, Styles.linkNavButton)
            }
        }
    }
}

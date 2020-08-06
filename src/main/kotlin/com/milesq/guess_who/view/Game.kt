package com.milesq.guess_who.view

import com.milesq.guess_who.app.Styles
import com.milesq.guess_who.model.TourNumber
import com.milesq.guess_who.model.readPersons
import javafx.geometry.Pos
import tornadofx.*

class Game: View() {
    val tourNumber: TourNumber by param()
    val possibleShowingTypes: List<String> by param()

//    private val persons = readPersons()
    override val root = borderpane {
        addClass(Styles.viewContainer)

        center = vbox {
            label("Nazwa postaci")

            vbox {
                addClass(Styles.bordered)
                style {
                    padding = box(15.px, 0.px)
                }
                vboxConstraints {
                    marginTop = 50.0
                }
                alignment = Pos.CENTER

                label("podstawowe informacje")
                label("podstawowe informacje")
                label("podstawowe informacje")
            }
        }

        // Exit button placed in bottom right corner
        bottom = borderpane {
            right = button("Wyjście") {
                addClass(Styles.linkButton, Styles.linkNavButton)
                action { replaceWith<Menu>() }
            }
        }
    }
}

package com.milesq.guess_who.view

import com.milesq.guess_who.app.Styles
import com.milesq.guess_who.model.Person
import com.milesq.guess_who.model.TourNumber
import com.milesq.guess_who.model.loadPersons
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*
import kotlin.random.Random

class Game: View() {
    val tourNumber: TourNumber by param()
    val possibleShowingTypes: List<String> by param()

    private val game: GameController by inject()

    init { game.nextPerson() }

    override val root = borderpane {
        addClass(Styles.viewContainer)

        center = vbox {
            label {
                bind(game.currentPerson)
            }

            vbox {
                addClass(Styles.bordered)
                style {
                    padding = box(15.px, 0.px)
                }
                vboxConstraints {
                    marginTop = 50.0
                }
                alignment = Pos.CENTER

                label(game.personTips)
            }
        }

        // Exit button placed in bottom right corner
        bottom = borderpane {
            left = button("Następne") {
                addClass(Styles.linkButton, Styles.linkNavButton, Styles.linkOkButton)
                action { game.nextPerson() }
            }

            center = vbox {
                padding = insets(5)
            }

            right = button("Wyjście") {
                addClass(Styles.linkButton, Styles.linkNavButton)
                action { replaceWith<Menu>() }
            }
        }
    }
}

class GameController: Controller() {
    private val defaultPersons = loadPersons().persons // destructuring is not allowed here
    private var persons: MutableList<Person> = defaultPersons.toMutableList()

    val currentPerson = SimpleStringProperty()
    val personTips = SimpleStringProperty()

    init { loadNewPerson() }

    fun nextPerson() {
        loadNewPerson()
    }

    private fun loadNewPerson() {
        if (persons.isEmpty())
            persons = defaultPersons.toMutableList()

        val nextPersonID = Random.nextInt(persons.size)

        val (name, tips) = persons[nextPersonID]
        persons.removeAt(nextPersonID)

        currentPerson.value = name
        personTips.value = tips.fold("") { acc, next -> "$acc\n- $next" }
    }
}

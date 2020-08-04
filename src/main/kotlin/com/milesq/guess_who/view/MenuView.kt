package com.milesq.guess_who.view

import com.milesq.guess_who.app.Game
import javafx.scene.Parent
import tornadofx.*

class MenuView: View("Zgadnij kto to") {
    override val root = vbox {
        addClass("view-container")

        borderpane {
            left<GameProperties>()
            right<GameController>()
        }
    }

    class GameController : View() {
        override val root = vbox {
            label("asd")
        }
    }

    class GameProperties: View() {
        override val root = vbox {
            label("ok")
        }
    }
}


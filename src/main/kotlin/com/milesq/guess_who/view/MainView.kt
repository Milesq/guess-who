package com.milesq.guess_who.view

import com.milesq.guess_who.app.Game
import tornadofx.*

class MenuView: View("Hello TornadoFX") {
    override val root = vbox {
        label("2")
        button("asd") {
            addClass("link-button")
            action {
                replaceWith<Game>()
            }
        }
    }
}

package com.milesq.guess_who.view

import tornadofx.*

class Settings: View("Ustawienia") {
    override val root = hbox {
        button("Ustawienia").action {
            replaceWith<Menu>()
        }
    }
}

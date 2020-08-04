package com.milesq.guess_who.view

import javafx.scene.control.Alert
import tornadofx.*

class MenuView : View("Hello TornadoFX") {
    override val root = vbox {
        label("2")
        button("asd") {
            action {
                alert(Alert.AlertType.INFORMATION, "sad")
            }
        }
    }
}

package com.milesq.guess_who.app

import javafx.scene.Cursor
import tornadofx.*

class Styles: Stylesheet() {
    companion object {
        val linkButton by cssclass()
        val linkNavButton by cssclass()
        val root by cssclass("root")
        val viewContainer by cssclass()
    }

    init {
        root {
            fontSize = 16.px
        }

        viewContainer {
            padding = box(50.px)
        }

        label {
            padding = box(5.px)
        }

        linkButton {
            backgroundColor += c(200, 191, 231)
            padding = box(10.px, 15.px)
            backgroundRadius = multi(box(13.px))

            and(hover) {
                backgroundColor += c(220, 211, 251)
                cursor = Cursor.HAND
            }

            and(linkNavButton) {
              prefWidth = 150.px
            }
        }
    }
}

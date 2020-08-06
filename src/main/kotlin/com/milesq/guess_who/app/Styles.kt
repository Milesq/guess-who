package com.milesq.guess_who.app

import javafx.scene.Cursor
import tornadofx.*

class Styles: Stylesheet() {
    companion object {
        val linkButton by cssclass()
        val linkNavButton by cssclass()
        val bordered by cssclass()
        val root by cssclass("root")
        val viewContainer by cssclass()
    }

    init {
        root {
            fontSize = 20.px
        }

        viewContainer {
            padding = box(50.px)
        }

        label {
            padding = box(5.px)
        }

        bordered {
            borderColor += box(c("#a1a1a1"))
            borderWidth += box(1.px)
            padding = box(35.px, 20.px)
        }

        linkButton {
            backgroundColor += c(200, 191, 231)
            padding = box(15.px, 20.px)
            backgroundRadius = multi(box(13.px))

            and(hover) {
                backgroundColor += c(220, 211, 251)
                cursor = Cursor.HAND
            }

            and(linkNavButton) {
              prefWidth = 170.px
            }
        }
    }
}

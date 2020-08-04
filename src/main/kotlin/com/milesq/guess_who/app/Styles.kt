package com.milesq.guess_who.app

import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.px

class Styles : Stylesheet() {
    init {
        label {
            padding = box(5.px)
            fontSize = 24.px
        }
    }
}

package com.milesq.guess_who.app

import com.milesq.guess_who.view.MenuView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MenuView::class, Styles::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 726.0
        stage.height = 409.0
    }
}

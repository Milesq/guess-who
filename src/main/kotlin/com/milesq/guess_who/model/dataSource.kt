package com.milesq.guess_who.model

import java.io.File

fun showingWays(): List<String> {
    val waysOfShowing = mutableListOf<String>()
    File("./waysOfShowing.txt").forEachLine { waysOfShowing.add(it) }

    return waysOfShowing
}

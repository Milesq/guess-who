package com.milesq.guess_who.model

import java.io.File

private fun readFile(name: String): List<String> {
    val listToReturn = mutableListOf<String>()
    File(name).forEachLine { listToReturn.add(it) }

    return listToReturn
}

fun readShowingWays(): List<String> = readFile("./waysOfShowing.txt")
fun readPersons(): List<String> = readFile("./persons.txt")

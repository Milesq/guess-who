package com.milesq.guess_who.model

import com.beust.klaxon.Klaxon
import java.io.File

private fun readFile(name: String): List<String> {
    val listToReturn = mutableListOf<String>()
    File(name).forEachLine { listToReturn.add(it) }

    return listToReturn
}

fun readShowingWays(): List<String> = readFile("./waysOfShowing.txt")

data class Person(val name: String, val tips: List<String>)
data class Persons(val persons: List<Person>)

fun loadPersons(): Persons =
    Klaxon()
        .parse<Persons>(File("./persons.json"))
        ?: Persons(listOf())

package flashcards

import java.io.File
import kotlin.collections.ArrayList
import kotlin.random.Random

class Flashcards {
    var done: Boolean = false
    private var cards: MutableMap<String,String>

    init {
        done = false
        cards = mutableMapOf()
    }
    fun add() {
        println("The card:")
        val term:String = readLine()!!
        if (cards.containsKey(term)) {
            return println("The card \"$term\" already exists.")
        }
        println("The definition of the card:")
        val definition: String = readLine()!!
        if (cards.containsValue(definition)) {
            return println("The definition \"$definition\" already exists. Try again:")
        }
        cards[term] = definition
        println("The pair (\"$term\":\"$definition\") has been added.")
    }
    fun remove() {
        println("Which card?")
        val term: String = readLine()!!
        if (cards.containsKey(term)) {
            cards.remove(term)
            println("The card has been removed.")
        } else { println("Can't remove \"$term\": there is no such card.") }
    }
    fun import() {
        println("File name:")
        val importFile = File(readLine()!!)
        if (!importFile.exists()) {
            println("File not found.")
        } else {
            var cardsAdded = 0
            importFile.forEachLine {
                val card = it.split(":")
                cards[card[0]] = card[1]
                cardsAdded++
            }
            println("$cardsAdded cards have been loaded.")
        }

    }
    fun export() {
        println("File name:")
        File(readLine()!!).writeText(cards.entries.joinToString(separator = "") { "${it.key}:${it.value}\n" } )
        println("${cards.size} cards have been saved.")
    }
    fun ask() {
        println("How many times to ask?")
        for ( i in 1..readLine()!!.toInt()) {
            val term = ArrayList(cards.keys)[Random.nextInt(cards.size)]
            val definition = cards[term]
            println("Print the definition of \"$term\":")
            val answer = readLine()!!
            when {
                answer == definition -> println("Correct!")
                cards.containsValue(answer) -> {
                    val otherCard = cards.filter { it.value == answer }.keys.first()
                    println("Wrong. The right answer is \"$definition\", but your definition is correct for \"$otherCard\"")
                }
                else -> println("Wrong. The right answer is \"$definition\"")
            }
        }
    }
    fun exit() {
        println("Bye bye!")
        done = true
    }
}

fun main() {
    val deck = Flashcards()
    do {
        println("input the action (add, remove, import, export, ask, exit):")
        when(readLine()!!) {
            "add" -> deck.add()
            "remove" -> deck.remove()
            "import" -> deck.import()
            "export" -> deck.export()
            "ask" -> deck.ask()
            "exit" -> deck.exit()
        }
    } while (!deck.done)
}

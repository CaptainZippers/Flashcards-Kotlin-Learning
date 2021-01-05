package flashcards

import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    println("Input the number of cards:")
    val numberOfCards = input.nextLine().toInt()
    val cards = mutableMapOf<String, String>()
    for (i in 1..numberOfCards) {
        println("Card #$i:")
        var term:String
        var check1 = false
        do {
            term = input.nextLine()
            if (cards.containsKey(term)) {
                println("The card \"$term\" already exists. Try again:")
            } else { check1 = true }
        } while (!check1)
        println("The definition for card #$i:")
        var definition: String
        var check2 = false
        do {
            definition = input.nextLine()
            if (cards.containsValue(definition)) {
                println("The definition \"$definition\" already exists. Try again:")
            } else { check2 = true }
        } while (!check2)
        cards[term] = definition
    }
    for ((term, definition) in cards) {
        println("Print the definition of \"$term\":")
        val answer = input.nextLine()
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

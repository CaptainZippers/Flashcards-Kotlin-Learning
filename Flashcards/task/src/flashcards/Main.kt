package flashcards

import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    println("Input the number of cards:")
    val numberOfCards = input.nextLine().toInt()
    class Cards(val term:String, val definition: String)
    val cards = arrayListOf<Cards>()
    for (i in 1..numberOfCards) {
        println("Card #$i:")
        val term = input.nextLine()
        println("The definition for card #$i:")
        val definition = input.nextLine()
        cards.add(Cards(term,definition))
    }
    for (card in cards) {
        println("Print the definition of \"${card.term}\":")
        println(if (input.nextLine() == card.definition) "Correct" else "Wrong. The right answer is \"${card.definition}\"")
    }
}

package flashcards

import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    input.nextLine()
    print("Your answer is ${if (input.nextLine() == input.nextLine())"right!" else "wrong..."}")
}

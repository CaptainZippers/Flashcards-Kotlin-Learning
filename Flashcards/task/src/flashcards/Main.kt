package flashcards

import java.io.File
import kotlin.collections.ArrayList
import kotlin.random.Random

class Flashcards {
    var done: Boolean = false
    private var cards: MutableMap<String,String>
    private var errors: MutableMap<String, Int>
    var logs:MutableList<String>

    init {
        done = false
        cards = mutableMapOf()
        logs = mutableListOf()
        errors = mutableMapOf()
    }
    fun printNLog(printLine: String) {
        logs.add("$printLine\n")
        println(printLine)
    }
    fun add() {
        printNLog("The card:")
        val term:String = readLine()!!
        logs.add("$term\n")
        if (cards.containsKey(term)) return printNLog("The card \"$term\" already exists.")
        printNLog("The definition of the card:")
        val definition: String = readLine()!!
        logs.add("$definition\n")
        if (cards.containsValue(definition)) return printNLog("The definition \"$definition\" already exists. Try again:")
        cards[term] = definition
        printNLog("The pair (\"$term\":\"$definition\") has been added.")
    }
    fun remove() {
        printNLog("Which card?")
        val term: String = readLine()!!
        logs.add("$term\n")
        if (cards.containsKey(term)) {
            cards.remove(term)
            if (errors.containsKey(term)) errors.remove(term)
            printNLog("The card has been removed.")
        } else { printNLog("Can't remove \"$term\": there is no such card.") }
    }
    fun import(_filename: String?) {
        if (_filename === null) printNLog("File name:")
        val filename = _filename ?: readLine()!!
        if (_filename === null) logs.add("$filename\n")
        val importFile = File(filename)
        if (!importFile.exists()) printNLog("File not found.")
        else {
            var cardsAdded = 0
            importFile.forEachLine {
                val card = it.split(":")
                cards[card[0]] = card[1]
                if (card[2].toInt() > 0) { errors[card[0]] = card[2].toInt() }
                cardsAdded++
            }
            printNLog("$cardsAdded cards have been loaded.")
        }
    }
    fun export(_filename: String?) {
        if (_filename === null) printNLog("File name:")
        val filename = _filename ?: readLine()!!
        if (_filename === null) logs.add("$filename\n")
        File(filename).writeText(cards.entries.joinToString(separator = "") { "${it.key}:${it.value}:${if (errors.containsKey(it.key)) errors[it.key] else 0}\n" } )
        printNLog("${cards.size} cards have been saved.")
    }
    fun ask() {
        printNLog("How many times to ask?")
        val numOfQuestions = readLine()!!
        logs.add("$numOfQuestions\n")
        for ( i in 1..numOfQuestions.toInt()) {
            val term = ArrayList(cards.keys)[Random.nextInt(cards.size)]
            val definition = cards[term]
            printNLog("Print the definition of \"$term\":")
            val answer = readLine()!!
            logs.add("$answer\n")
            when {
                answer == definition -> printNLog("Correct!")
                cards.containsValue(answer) -> {
                    val otherCard = cards.filter { it.value == answer }.keys.first()
                    if (errors.containsKey(term)) { errors[term] = errors[term]!!.plus(1) }
                    else { errors[term] = 1 }
                    printNLog("Wrong. The right answer is \"$definition\", but your definition is correct for \"$otherCard\"")
                }
                else -> {
                    if (errors.containsKey(term)) { errors[term] = errors[term]!!.plus(1) }
                    else { errors[term] = 1 }
                    printNLog("Wrong. The right answer is \"$definition\"")
                }
            }
        }
    }
    fun log() {
        printNLog("File name:")
        val filename = readLine()!!
        logs.add("$filename\n")
        val file = File(filename)
        file.writeText("")
        for (line in logs) file.appendText(line)
        println("to pass the test")
        printNLog("The log has been saved.")
    }
    fun hardestCard() {
        if (errors.isEmpty()) printNLog("There are no cards with errors.")
        else {
            val maxErrors = errors.values.maxOrNull()
            val hardestTermsList = errors.filter { it.value == maxErrors }.keys.reversed()
            val hardestTerms = hardestTermsList.joinToString { "\"$it\"" }
            printNLog("The hardest card${if (hardestTermsList.size == 1) "" else "s"} ${if (hardestTermsList.size == 1) "is" else "are"} $hardestTerms. You have $maxErrors error${if (maxErrors == 1) "" else "s"} answering ${if (hardestTermsList.size == 1) "it" else "them"}.")
        }
    }
    fun resetStats() {
        errors.clear()
        printNLog("Card statistics have been reset.")
    }
    fun exit(_filename: String?) {
        if (_filename !== null) this.export(_filename)
        printNLog("Bye bye!")
        done = true
    }
}

fun main(args: Array<String>) {
    val deck = Flashcards()
    val exportFilenameIndex = args.indexOf("-export")
    var exportFilename: String? = null
    if (exportFilenameIndex != -1 ) exportFilename = args[ exportFilenameIndex + 1 ]
    val importFilenameIndex = args.indexOf("-import")
    if (importFilenameIndex != -1 ) deck.import(args[ importFilenameIndex + 1 ])
    do {
        deck.printNLog("input the action (add, remove, import, export, ask, exit):")
        val command = readLine()!!
        val add = deck.logs.add("$command\n")
        when(command) {
            "add" -> deck.add()
            "remove" -> deck.remove()
            "import" -> deck.import(null)
            "export" -> deck.export(null)
            "ask" -> deck.ask()
            "log" -> deck.log()
            "hardest card" -> deck.hardestCard()
            "reset stats" -> deck.resetStats()
            "exit" -> deck.exit(exportFilename)
        }
    } while (!deck.done)
}

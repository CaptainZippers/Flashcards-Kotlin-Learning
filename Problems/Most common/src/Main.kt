fun main() {
    val words = mutableMapOf<String, Int>()
    do {
        val word = readLine()!!
        if (word == "stop") {
            continue
        } else if (words.containsKey(word)) {
            words[word] = words[word]!!.plus(1)
        } else {
            words[word] = 1
        }
    } while (word != "stop")
    var mostCommonWord = "null"
    var mostCommonTimes = 0
    for ((key, value) in words) {
        if (value > mostCommonTimes) {
            mostCommonWord = key
            mostCommonTimes = value
        }
    }
    print(mostCommonWord)
}

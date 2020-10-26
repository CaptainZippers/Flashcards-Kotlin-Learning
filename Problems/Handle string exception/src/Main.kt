fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    if (index <= -1 || index > word.lastIndex ) {
        return print("There isn't such an element in the given string, please fix the index!")
    }
    println(word[index])
}

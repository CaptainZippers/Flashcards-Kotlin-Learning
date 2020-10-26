import java.util.*

fun main() {
    val letters = mutableMapOf<Int , Char>()
    var count = 0
    do {
        val s = readLine()!!.toCharArray().first()
        letters[count] = s
        count++
    } while (s != 'z')
    if ( letters.size < 4) {
        print("null")
    } else {
        print(letters[3])
    }
}

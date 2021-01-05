import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    var input = scanner.next().toInt()
    for (i in 1..3) {
        val input2 = scanner.next().toInt()
        if (input < input2) { input = input2 }
    }
    print(input)
}

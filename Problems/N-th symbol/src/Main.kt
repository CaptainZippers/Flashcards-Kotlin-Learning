import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val input = scanner.nextLine()
    val index = scanner.nextInt()

    print("Symbol # $index of the string \"$input\" is \'${input[index - 1]}\'")
}

import java.util.*

fun main(args: Array<String>) {
    // put your code here
    val input = Scanner(System.`in`)
    val numerator = input.nextInt()
    val denomenator = input.nextInt()
    if (denomenator == 0) {
        print("Division by zero, please fix the second argument!")
    } else {
        print(numerator/denomenator)
    }
}

import java.lang.ArithmeticException
import java.lang.NumberFormatException

fun intDivision(x: String, y: String): Int {
    val xint: Int
    val yint: Int
    try {
        xint = x.toInt()
        yint = y.toInt()
        try {
            return xint / yint
        } catch (e: ArithmeticException) {
            println("Exception: division by zero!")
            return 0
        }
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
        return 0
    }
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}

import java.util.Scanner
import kotlin.math.floor

fun main() {
    val scanner = Scanner(System.`in`)
    // put your code here
    val digit = scanner.next().toDouble()
    print(floor(10 * (digit - floor(digit))).toInt())
}

import java.util.*
import kotlin.math.cos
import kotlin.math.sin

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // write your code here
    val rad = scanner.next().toDouble()
    val sine = sin(rad)
    val cos = cos(rad)
    println(sine - cos)
}

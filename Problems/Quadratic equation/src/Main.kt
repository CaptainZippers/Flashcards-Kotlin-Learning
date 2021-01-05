import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    // put your code here
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val root = Math.sqrt(Math.pow(b, 2.0) - 4 * a * c)
    val x = (0 - b + root) / (2 * a)
    val y = (0 - b - root) / (2 * a)
    print("${Math.min(x,y)} ${Math.max(x,y)}")
}

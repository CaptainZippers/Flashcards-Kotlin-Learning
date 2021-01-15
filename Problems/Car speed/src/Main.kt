fun main(args: Array<String>) {
    val speed = readLine()!!.toInt()
    val speedLimitString = readLine()!!
    var speedLimit = 60
    if (speedLimitString != "no limit") speedLimit = speedLimitString.toInt()
    when {
        speed <= speedLimit -> println("Within the limit")
        speed > speedLimit -> println("Exceeds the limit by ${speed - speedLimit} kilometers per hour")
    }
}

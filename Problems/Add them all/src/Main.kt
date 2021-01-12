fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
    // put your code here
    val third = first.toMutableList()
    third.addAll(second)
    return third
}

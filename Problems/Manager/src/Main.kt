class Task(val name: String)
object Manager {
    var solvedTask:Int = 0
    fun solveTask(task:Task) {
        println("Task ${task.name} solved!")
        solvedTask++
    }
}
// create the Manager singleton here

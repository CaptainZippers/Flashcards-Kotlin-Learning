fun main(args: Array<String>) {
    if (args.size != 3) println("Invalid number of program arguments")
    else for (index in 0..args.lastIndex) println("Argument ${index + 1}: ${args[index]}. It has ${args[index].length} characters")
}

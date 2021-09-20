/********************************************************************
Mad 105 - Intro to Arrays

Programmer: Brian Veitch

Purpose:   Define and use an array. Print elements of the array to screen.
 Loop through array two different ways.
 *********************************************************************/


fun main() {
    val hotDogItems = arrayOf("hot dog", "bun", "ketchup", "mustard", "salt", "pickle", "tomatoes", "relish", "onion")

    println("Hot dog stand items")
    for (item in hotDogItems) {
        println(item)
    }

    println("\n======================================================\n")

    println("Hot dog stand items")
    for (i in 0 until hotDogItems.size -1) {
        println(hotDogItems[i])
    }

}
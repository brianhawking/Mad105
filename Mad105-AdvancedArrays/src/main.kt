/********************************************************************
Mad 105 - Advanced Arrays

Programmer: Brian Veitch

Purpose:   Define and use a multidimensional array

 I want to set up the array in two different ways. The first
 will be like the video. The second is the way I would have done it.
 *********************************************************************/


fun main() {


    val hotDogItems = arrayOf("hot dog", "bun", "ketchup", "mustard", "salt", "pickle", "tomatoes", "relish", "onion")
    val quantity = arrayOf("5", "18", "50", "72", "200", "14", "7", "18", "8")

    firstWay(hotDogItems, quantity)
    secondWay()

    println("Hot dog stand items")
    for (i in 0 until hotDogItems.size) {
        println("There are ${quantity[i]} items of ${hotDogItems[i]} left.")
    }
}


fun firstWay(items: Array<String>, quantity: Array<String>) {
    println("First way")
}

fun secondWay() {
    println("Second way")
}
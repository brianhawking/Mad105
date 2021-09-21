/********************************************************************
Mad 105 - Advanced Arrays

Programmer: Brian Veitch

Purpose:   Define and use a multidimensional array

I want to set up the array in two different ways. The first
will be like the video. The second is the way I would have done it.
 *********************************************************************/


fun main() {


    val hotDogItems = arrayOf("hot dogs", "buns", "packets of ketchup", "packets of mustard", "packets of salt", "pickles", "tomatoes", "packets of relish", "onions")
    val quantity = arrayOf("5", "18", "50", "72", "200", "14", "7", "18", "8")

    // print without combining items and quantity
    header("Hot dog items and quantity")
    for (i in hotDogItems.indices) {
        println("There are ${quantity[i]} ${hotDogItems[i]} left.")
    }

    header("First way to combine arrays")

    // different ways to combine the arrays into one multidimensional
    firstWay(hotDogItems, quantity)

    header("Second way to combine arrays")

    secondWay(hotDogItems, quantity)


}

fun header(text: String) {
    println("===================================")
    println(text)
    println("===================================")
}

fun firstWay(items: Array<String>, quantity: Array<String>) {
    var inventory = arrayOf<Array<String>>()

    inventory += items
    inventory += quantity

    for (i in inventory[0].indices) {
        val item = inventory[0][i]
        val qty = inventory[1][i]
        println("There are $qty $item left")
    }
}

fun secondWay(items: Array<String>, quantity: Array<String>) {
    var inventory = arrayOf<Array<String>>()

    for (i in items.indices) {
        inventory += arrayOf(items[i], quantity[i])
    }

    for (i in inventory.indices) {
        val item = inventory[i][0]
        val qty = inventory[i][1]
        println("There are $qty $item left.")
    }
}
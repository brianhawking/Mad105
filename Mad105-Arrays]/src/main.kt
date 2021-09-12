/*
Create an array that lists type of supplies for a simple hot dog stand, ice cream shop, coffee shop or something similar.
Use a for loop to print the contents of the array on the screen. You will use this as the start of the next program.
You need at least 5 items in your array.
 */

fun main() {
    val hotDogItems = arrayOf("hot dog", "bun", "ketchup", "mustard", "salt", "pickle", "tomatoes")
    val iceCreamItems = arrayOf("vanilla", "chocolate", "strawberry", "cone", "bowl", "chocolate chips", "sprinkles")
    val smoothieItems = arrayOf("blender", "milk", "strawberries", "banana", "apple", "acai", "blueberries", "peach", "small", "medium", "large")

    println("Hot dog stand items")
    for (item in hotDogItems) {
        println(item)
    }

    println("Ice cream shop items")
    for (i in 0 until iceCreamItems.size -1) {
        println(iceCreamItems[i])
    }

    println("Smoothie ship items")
    for (item in smoothieItems) {
        println(item)
    }

}
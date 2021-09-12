/*
The array should hold inventory items and count of items in inventory.
The user should be able to search for any item and have the item name and amount on hand appear on screen (format them nicely).
The user should be able to add or subtract from any of the inventory. Have an error message if the count would become less than 0, and set the count to 0. Display the name of the item, the original amount, the amount added or taken away, and the new tota
 */

fun main() {
    val hotDogItems = arrayOf(
        arrayOf("hot dog", 4),
        arrayOf("bun", 18),
        arrayOf("ketchup", 50),
        arrayOf("mustard", 72),
        arrayOf("salt", 200),
        arrayOf("pickle", 14),
        arrayOf("tomatoes", 7)
    )
    val iceCreamItems = arrayOf("vanilla", "chocolate", "strawberry", "cone", "bowl", "chocolate chips", "sprinkles")
    val smoothieItems = arrayOf("milk", "strawberries", "banana", "apple", "acai", "blueberries", "peach", "small", "medium", "large")

    println("Hot dog stand items")
    for (item in hotDogItems) {
        println("There are ${item[1]} items of ${item[0]} left.")
    }

//    println("Ice cream shop items")
//    for (i in 0 until iceCreamItems.size -1) {
//        println(iceCreamItems[i])
//    }
//
//    println("Smoothie ship items")
//    for (item in smoothieItems) {
//        println(item)
//    }

}
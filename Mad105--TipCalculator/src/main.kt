/********************************************************************
Mad 105 - Tip Calculator

Programmer: Brian Veitch

Purpose:   User enters the cost of items. Program will display total cost, taxes
total with taxes, and a recommended tip.
 *********************************************************************/

import java.text.DecimalFormat

fun main() {

    // constants
    val tax = 0.025
    val recommendedTip = 0.175
    val twoDigits = DecimalFormat("'$'###,###,##0.00")

    // variables
    var itemCost: Double
    var itemsArray : Array<Double> = arrayOf()

    var totalCost = 0.0


    // prompt user to enter an item cost
    do {
        itemCost = getCost()
        itemsArray += itemCost
    } while (itemCost != 0.0)

    // get total of all items
    for (item in itemsArray) {
        totalCost += item
    }

    // get total tax
    val totalTax: Double = tax * totalCost

    // get tip amount
    val tip: Double = (recommendedTip * totalCost)

    val total = totalCost + totalTax + tip

    // display results
    println("\n==== Total ===============================")
    println("Subtotal:      ${twoDigits.format(totalCost)}")
    println("Tax:           ${twoDigits.format(totalTax)}")
    println("Tip: (17.5%)   ${twoDigits.format(tip)}")
    println("Total:         ${twoDigits.format(total)}")

}

// validates user input, make sure it's non-negative
fun getCost(): Double {

    var itemCost: Double
    do {
        print("Enter item cost (0 to quit): ")
        itemCost = readLine()!!.toDouble()
        if (itemCost < 0) {
            println("Invalid cost. Please try again.")
        }
    } while (itemCost < 0)

    return itemCost
}
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
    var tip: Double = (recommendedTip * totalCost)

    val total = totalCost + totalTax + tip

    // display results
    println("\n==== Total ===============================")
    println("Subtotal:      ${twoDigits.format(totalCost+0.001)}")
    println("Tax:           ${twoDigits.format(totalTax+0.001)}")
    println("Tip: (17.5%)   ${twoDigits.format(tip+0.001)}")
    println("Total:         ${twoDigits.format(total+0.001)}")

    do {
        // ask for a different tip
        println("Do you want to use a different tip?")
        println("Enter 1 for Yes")
        println("Enter 2 for No")
        val choice = readLine()!!.toInt()

        if (choice == 1) {
            // recalculate
            print("Enter a new tip percentage (Ex. 5.2): ")
            val tipPercentage = readLine()!!.toDouble()
            tip = tipPercentage / 100 * totalCost

            // display results
            println("\n==== Total ===============================")
            println("Subtotal:      ${twoDigits.format(totalCost+0.001)}")
            println("Tax:           ${twoDigits.format(totalTax+0.001)}")
            println("Tip: ($tipPercentage%)   ${twoDigits.format(tip+0.001)}")
            println("Total:         ${twoDigits.format(total+0.001)}")
        }



    } while (choice != 2)

    println("\nHave a great day.")

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
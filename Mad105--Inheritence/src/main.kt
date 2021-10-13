/**
 * Function - main
 * @author - Brian Veitch
 * date - 10/8
 * @param
 * userChoice - get input from user
 * @description
 * Get customer information (residential or commercial) for a landscaping quote
 *
 * mods
 * BV
 */

fun main() {

    var userChoice: Int

    do {
        println("1) Residential")
        println("2) Commercial")
        println("3) Done")
        print("Select the type of customer: ")

        userChoice = readLine()!!.toInt()

        when (userChoice) {
            1 -> getCustomerInfo("Residential")
            2 -> getCustomerInfo("Commercial")
            3 -> println("Have a great day.")
            else -> println("============================\nInvalid selection. Try again\n============================")
        }
    } while( userChoice != 3)
}


/**
 * Function - getCustomerInfo
 * @author - Brian Veitch
 * date - 10/8
 * @param
 * type, is the customer residential or commercial
 * customerName - name of customer
 * customerPhone - phone number of customer
 * customerAddress - address of customer
 * squareFootage - square footage of area needing maintenance
 *
 * @description
 * get user info (name, address, phone, etc.)
 *
 * mods
 * BV
 */
fun getCustomerInfo(type: String) {

    print("Customer name: ")
    val customerName: String = readLine()!!.toString()

    print("Customer phone: ")
    var customerPhone: String = readLine()!!.toString()

    print("Customer Address: ")
    var customerAddress: String = readLine()!!.toString()

    print("What is your square footage? ")
    var squareFootage: Double = getPositiveDouble()

    when (type) {
        "Residential" -> {

            var userInput: Int
            do {
                print("Are you a senior? Enter 1 for Yes, 2 for No. ")
                userInput = readLine()!!.toInt()
                if ((userInput != 1) and (userInput != 2)) {
                    println("Invalid entry. Are you a senior? Enter 1 for Yes, 2 for No. ")
                }
            } while ( (userInput != 1) and (userInput != 2))

            var isSenior = when (userInput) {
                1 -> true
                else -> false
            }

            val customer = Residential(isSenior,customerName, customerPhone, customerAddress, squareFootage)

            customer.calculateQuote()
        }
        "Commercial" -> {

            print("Property name: ")
            var propertyName = readLine()!!.toString()

            var userInput: Int
            do {
                print("Does this cover multiple properties? Enter 1 for Yes, 2 for No. ")
                userInput = readLine()!!.toInt()
                if ((userInput != 1) and (userInput != 2)) {
                    println("Invalid entry. Does this cover multiple properties? Enter 1 for Yes, 2 for No. ")
                }
            } while ( (userInput != 1) and (userInput != 2))

            var isMultiProperty = when (userInput) {
                1 -> true
                else -> false
            }

            val customer = Commercial(propertyName, isMultiProperty, customerName, customerPhone, customerAddress, squareFootage)

            customer.calculateQuote()
        }
    }

}

/**
 * Function getPositiveDouble
 * @author - Brian Veitch
 * @params
 * userInput - get user input from console
 * @description
 * get userinput, make sure it's a positive number
 */
fun getPositiveDouble() : Double {
    var userInput: Double
    do {
        userInput = readLine()!!.toDouble()
        if (userInput <= 0) {
            println("Invalid square footage. Please enter a positive number.")
            print("Enter your square footage: ")
        }
    } while (userInput <= 0)

    return userInput
}
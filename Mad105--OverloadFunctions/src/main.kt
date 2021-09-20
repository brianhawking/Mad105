/********************************************************************
Mad 105 - Overload a function

Programmer: Brian Veitch

Purpose:   Practice writing overloaded functions.

 User is prompted to choose Business or Residential. The function
 StoreCustomerInfo is called but with different parameters depending
 on if you are a business or residential customer.
 *********************************************************************/

fun main() {

    var userChoice: Int
    var businessName = ""

    do {
        println("1) Business Customer")
        println("2) Residential Customer")
        print("Enter the number of your selection: ")
        userChoice = getCustomerType()

        if (userChoice == 1) {
            print("Please enter your business name: ")
            businessName = readLine()!!.toString()
        }

        print("Please enter your contact name: ")
        val contactName = readLine()!!.toString()

        print("Please enter your phone number: ")
        val phoneNumber = readLine()!!.toString()

        when (userChoice) {
            1 -> storeCustomerInfo(businessName, contactName, phoneNumber)
            2 -> storeCustomerInfo(contactName, phoneNumber)
        }



    } while (userChoice != 0)

}

fun getCustomerType():Int {

    var number: Int
    do {
        number = readLine()!!.toInt()
        if (number !in 1..2) {
            println("Invalid selection. Try again. ")
            println("1) Business Customer")
            println("2) Residential Customer")
            print("Enter the number of your selection: ")
        }
    } while (number !in 1..2)

    return number
}

fun storeCustomerInfo(business: String, contact: String, phone: String) {
    println(business)
    println(contact)
    println(phone)
}

fun storeCustomerInfo(contact: String, phone: String) {
    println(contact)
    println(phone)
}


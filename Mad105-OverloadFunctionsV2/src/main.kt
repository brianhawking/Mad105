fun storeCustomerInfo(business: String, contact: String, phone: String) {
    println(business)
    println(contact)
    println(phone)
}

fun storeCustomerInfo(contact: String, phone: String) {
    println(contact)
    println(phone)
}

fun main() {

    var userChoice: Int
    var businessName: String = ""

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

}fun getCustomerType():Int {

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


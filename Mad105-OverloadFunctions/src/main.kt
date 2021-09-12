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

    do {
        println("1) Business Customer")
        println("2) Residential Customer")
        print("Enter the number of your selection: ")
        userChoice = readLine()!!.toInt()

        if (userChoice == 1) {
            print("Please enter your business name: ")
            val businessName = readLine()!!.toString()

            print("Please enter your contact name: ")
            val contactName = readLine()!!.toString()

            print("Please enter your phone number: ")
            val phoneNumber = readLine()!!.toString()

            storeCustomerInfo(business: businessName, contact: contactName, number: phoneNumber)
        }



    } while (userChoice != 0)

}


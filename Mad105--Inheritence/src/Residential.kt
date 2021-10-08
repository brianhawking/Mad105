import java.text.DecimalFormat

class Residential(
    var isSenior: Boolean,
    customerName: String,
    customerPhone: String,
    customerAddress: String,
    squareFootage: Double
) : Customer(customerName, customerPhone, customerAddress, squareFootage){

    val rate: Double = 6.00
    val seniorDiscount: Double = 0.15
    var weeklyCost: Double = 0.0
    val twoDigits = DecimalFormat("'$'###,###,##0.00")

    init {
        println("Residential account created for $customerName")
    }

    fun calculateQuote() {
        if (isSenior) {
            weeklyCost = (1-seniorDiscount) * (squareFootage/1000) * rate
        }
        else {
            weeklyCost = (squareFootage/1000) * rate
        }

        println("\n========== Residential Quote =============")
        println("Customer Name: $customerName")
        println("Customer Phone: $customerPhone")
        println("Customer Address: $customerAddress")
        println("Total Sq. Footage: $squareFootage")
        println("Senior Discount: ${(isSenior.toString()).uppercase()}")
        println("Quote for weekly charge: ${twoDigits.format(weeklyCost)}")
        println("==========================================\n")
    }
}
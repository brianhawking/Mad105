import java.text.DecimalFormat

/**
 * Class - Commercial
 * @author - Brian Veitch
 * date - 10/8
 * @param
 * customerName - name of customer
 * customerPhone - phone number of customer
 * customerAddress - address of customer
 * squareFootage - square footage of area needing maintenance
 * propertyName - name of commercial property
 * rate - how much per 1000 square feet
 * multiPropertyDiscount - boolean, does the request involve multiple properties
 * weeklyCost - total weekly cost of maintenance
 *
 * mods
 * BV
 */
class Commercial(
    var propertyName: String,
    var isMultiProperty: Boolean,
    customerName: String,
    customerPhone: String,
    customerAddress: String,
    squareFootage: Double
) : Customer(customerName, customerPhone, customerAddress, squareFootage){

    val rate: Double = 5.00
    val multiPropertyDiscount: Double = 0.10
    var weeklyCost: Double = 0.0
    val twoDigits = DecimalFormat("'$'###,###,##0.00")

    init {
        println("Commercial account created for $customerName")
    }

    fun calculateQuote() {
        if (isMultiProperty) {
            weeklyCost = (1-multiPropertyDiscount) * (squareFootage/1000) * rate
        }
        else {
            weeklyCost = (squareFootage/1000) * rate
        }

        println("\n========== Commercial Quote =============")
        println("Property Name: $propertyName")
        println("Customer Name: $customerName")
        println("Customer Phone: $customerPhone")
        println("Customer Address: $customerAddress")
        println("Total Sq. Footage: $squareFootage")
        println("Multi-property Discount: ${(isMultiProperty.toString()).uppercase()}")
        println("Quote for weekly charge: ${twoDigits.format(weeklyCost)}")
        println("==========================================\n")
    }
}
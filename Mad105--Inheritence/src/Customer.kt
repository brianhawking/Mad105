/**
 * Class - Customer
 * @author - Brian Veitch
 * date - 10/8
 * @param
 * customerName - name of customer
 * customerPhone - phone number of customer
 * customerAddress - address of customer
 * squareFootage - square footage of area needing maintenance
 *
 * mods
 * BV
 */

open class Customer(
    var customerName: String,
    var customerPhone: String,
    var customerAddress: String,
    var squareFootage: Double
) {
    init {
        println("Customer account created for $customerName")
    }
}
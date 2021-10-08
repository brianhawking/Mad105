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
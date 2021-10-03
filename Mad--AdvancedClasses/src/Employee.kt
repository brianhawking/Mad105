import java.text.DecimalFormat

class Employee(var name: String,
               var position: PositionTitle,
               var salary: Boolean,
               var payRate: Double,
               var shift: Int) {

    val OVERTIMERATE: Double = 1.5
    val twoDigits = DecimalFormat("'$'###,###,##0.00")
    var weeklyPay: Double = 0.0

    init {
        if (shift !in (1..3)) {
            println("Error: Invalid shift number")
            shift = 1
        }
    }

    // display employee info to console
    fun display() {
        println("Name: $name")
        println("Position: ${position.value}, On Salary: $salary, Shift: $shift")
        println("Rate of pay is: ${twoDigits.format(payRate)} per hour")
    }

    // calculate weekly pays
    fun calculate(hours: Double) {

        // determine if overtime is allowed
        when (salary) {
            true -> {
                // calculate weekly pay (no overtime allowed)
                weeklyPay = if (hours > 40) {
                    40 * payRate
                } else {
                    hours * payRate
                }

            }
            else -> {
                // calculate weekly pay (overtime allowed)
                weeklyPay = if (hours <= 40) {
                    hours * payRate
                } else {
                    val overTime = hours - 40.0
                    (40 * payRate) + (overTime * OVERTIMERATE * payRate)
                }
            }
        }

        // add weekly pay modifiers based on shift
        when (shift) {
            1 -> weeklyPay *= 1.0
            2 -> weeklyPay *= 1.05
            3 -> weeklyPay *= 1.10
            else -> {
                weeklyPay *= 1.0
            }
        }

        println("$name earned ${twoDigits.format(weeklyPay)} this week.\n")
    }

}
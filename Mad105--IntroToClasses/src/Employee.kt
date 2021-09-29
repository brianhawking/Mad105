class Employee(firstName: String, secondName: String, var id: String, var shiftNumber: Int) {

    var firstName = firstName
        set(value) {
            field = value
            fullName = "$firstName $secondName"
        }
    var secondName = secondName
        set(value) {
            field = value
            fullName = "$firstName $secondName"
        }
    var fullName: String

    init {
        println("Employee profile created for $firstName $secondName")
        fullName = "$firstName $secondName"
    }

    fun printAll() {
        println("========================================")
        println("Employee: $fullName")
        println("Employee ID: $id")
        println("Shift: $shiftNumber")
        println("========================================")
    }

}
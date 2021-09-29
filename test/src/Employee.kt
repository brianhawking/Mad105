class Employee(name: String) {
        private var name
                get() = name
                set(value) = TODO()
        var lastName: String

        init {
                println("Employee created: $name")
                lastName = name + "V"
        }

        fun printAll() {
                println("$name is an employee")
        }
}
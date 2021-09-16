fun main() {
    // variables
    var number = 1
    var numberString: String

    while (number != 0) {
        println("Enter a number between 1 and 10. 0 to quit")
        number = readLine()!!.toInt()

        numberString = when (number) {
            1 -> "Eins"
            2 -> "Zwei"
            3 -> "Drei"
            4 -> "Vier"
            5 -> "Funf"
            6 -> "Sechs"
            7 -> "Sieben"
            8 -> "Acht"
            9 -> "Neun"
            10 -> "Zehn"
            !in 1..10 -> "out of range"
            else -> "Something went wrong"
        }

        println("$number is $numberString")
    }

}
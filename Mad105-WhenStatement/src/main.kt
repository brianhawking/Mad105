fun main() {
    // variables
    var number = 1
    var numberString: String

    while (number != 0) {
        println("Enter a number between 1 and 10. 0 to quit")
        number = readLine()!!.toInt()

        when (number) {
            1 -> numberString = "Eins"
            2 -> numberString = "Zwei"
            3 -> numberString = "Drei"
            4 -> numberString = "Vier"
            5 -> numberString = "Funf"
            6 -> numberString = "Sechs"
            7 -> numberString = "Sieben"
            8 -> numberString = "Acht"
            9 -> numberString = "Neun"
            10 -> numberString = "Zehn"
            !in 1..10 -> numberString = "out of range"
            else -> numberString = "Something went wrong"
        }

        println("$number is $numberString")
    }

}
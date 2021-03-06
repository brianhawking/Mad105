fun main() {
    var userChoice: Int
    var genreChoice: String

    do {
        println("What can I help you find?")
        println("1) Mystery")
        println("2) Thriller")
        println("3) Science Fiction")
        println("4) Fantasy")
        println("5) Romance")
        println("6) Exit Menu")

        print("Select a choice: ")
        userChoice = readLine()!!.toInt()
        if (userChoice !in 1..6) {
            println("You selected an invalid number. Please try again.")
        }
        else {
//            println("You selected $userChoice) ${choices[userChoice-1]}")
            genreChoice = when (userChoice) {
                1 -> "Mystery"
                2 -> "Thriller"
                3 -> "Science Fiction"
                4 -> "Fantasy"
                5 -> "Romance"
                6 -> "Exit Menu"
                else -> "Error"
            }
            println("You selected $userChoice) $genreChoice")
        }

        println("==================================")


    } while (userChoice != 6)

    println("Have a great day!j")
}
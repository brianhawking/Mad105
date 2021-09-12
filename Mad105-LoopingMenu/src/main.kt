fun main() {
    var userChoice: Int
    val choices = arrayOf("Mystery", "Thriller", "Science Fiction", "Fantasy", "Romance", "Exit Menu")

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
            println("You selected $userChoice) ${choices[userChoice-1]}")
        }

        println("")


    } while (userChoice != 6)

    println("Have a great day!j")
}
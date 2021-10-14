import java.lang.Exception

class UserInput {

    fun getInt() : Int {
        var isValidInput: Boolean
        var userInput = 0

        do {
            try {
                userInput = readLine()!!.toInt()
                isValidInput = true
            } catch (e: Exception) {
//                e.printStackTrace()
                print("Not an integer. Please try again: ")
                isValidInput = false
            }
        } while (!isValidInput)

        return userInput
    }

    fun getDouble() : Double {
        var isValidInput: Boolean
        var userInput = 0.0

        do {
            try {
                userInput = readLine()!!.toDouble()
                isValidInput = true
            } catch (e: Exception) {
//                e.printStackTrace()
                print("Not an double. Please try again: ")
                isValidInput = false
            }
        } while (!isValidInput)

        return userInput
    }
}
/********************************************************************
Mad 105 - If else control statements

Programmer: Brian Veitch

Purpose:   User is prompted with entering a body temperature. Using if,else
 statements, program will output if body temperature is low, normal, or high.
 *********************************************************************/

fun main() {

    var temperature = 96.8F

    while (temperature != 0.0F) {
        println("Enter a body temperature. 0 to quit.")
        temperature = readLine()!!.toFloat()

        if (temperature < 97.5) {
            println("$temperature is low")
        }
        else if (temperature <= 99.5) {
            println("$temperature is normal")
        }
        else  {
            println("$temperature is high")
        }
    }

    println("Have a nice day!")

}
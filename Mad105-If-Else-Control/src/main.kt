fun main() {

    var temperature: Float = 96.8F

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
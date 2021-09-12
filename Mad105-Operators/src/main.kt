fun main() {

    // arithmetic operators (+, -, *, /, %)
    var num1 = 4 // intellij wanted me to remove the variable declaration in this line
    var num2: Int = -19
    val sum: Int = num1 + num2
    val diff: Int = num1 - num2
    val mult: Int = num1 * num2
    val div: Float = (num1.toFloat() / num2.toFloat())

    println("num1 = $num1, num2 = $num2")
    println("$num1 + $num2 = $sum")
    println("$num1 - $num2 = $diff")
    println("$num1 x $num2 = $mult")
    println("$num1 / $num2 = $div")
    println("$num2 % $num1 = ${num2 % num1}")

    // comparison operations (==, !=, <, >, <=, >=)
    println("$num1 == $num2: ${num1 == num2}")
    println("$num1 != $num2: ${num1 != num2}")
    println("$num1 < $num2: ${num1 < num2}")
    println("$num1 > $num2: ${num1 > num2}")
    println("$num1 >= $num2: ${num1 >= num2}")
    println("$num1 <= $num2: ${num1 <= num2}")

    // assignment operators (+=, -=, *=, /=, %=)
    var addFive: Int = num1
    var multFive: Int = num1

    addFive += 5
    multFive *= 5
    println("Increment $num1 by 5: $num1 + 5 = $addFive")
    println("Multiply $num1 by 5: $num1 x 5 = $multFive")



    // increment, decrement
    print("Increment $num1 by 1: ")
    num1++
    println(num1)

    print("Decrement $num2 by 1: ")
    num2--
    println(num2)


}
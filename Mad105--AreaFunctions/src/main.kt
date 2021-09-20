fun main() {

    var userChoice: Int

    do {
        println("1) Rectangle")
        println("2) Circle")
        println("3) Trapezoid")
        println("4) Triangle")
        println("5) Quit")
        print("Select the shape to find the area: ")

        userChoice = readLine()!!.toInt()

        when (userChoice) {
            1 -> areaOfRectangle()
            2 -> areaOfCircle()
            3 -> areaOfTrapezoid()
            4 -> areaOfTriangle()
            5 -> println("Have a great day.")
            else -> println("============================\nInvalid selection. Try again\n============================")
        }
    } while( userChoice != 5)
}

fun areaOfRectangle() {

    println("The area of a rectangle is length x width.")

    print("Enter the length: ")
    val length: Float = getPositiveFloat()

    print("Enter the width: ")
    val width: Float = getPositiveFloat()

    println("The area of your rectangle is $length x $width = ${length * width}")
    println("==================================================================")
}

fun areaOfCircle() {

    println("The area of a circle is pi * (radius)^2.")

    print("Enter the radius: ")
    val radius: Float = getPositiveFloat()

    println("The area of your circle is pi * ($radius)^2 = ${Math.PI * radius*radius}")
    println("==================================================================")

}

fun areaOfTrapezoid() {

    println("The area of a trapezoid is 1/2*H*(B+b), where B = length of long base, b = length of short base, and h = the height")

    print("Enter the long base B: ")
    val longBase: Float = getPositiveFloat()

    print("Enter the short base b: ")
    val shortBase: Float = getPositiveFloat()

    print("Enter the height H: ")
    val height: Float = getPositiveFloat()

    println("The area of your rectangle is 1/2*$height*($longBase + $shortBase) = ${0.5*height*(longBase + shortBase)}")
    println("==================================================================")

}

fun areaOfTriangle() {
    println("The area of a triangle is 1/2*B*H, where B = length the base, and H = the height")

    print("Enter the base B: ")
    val base: Float = getPositiveFloat()

    print("Enter the height H: ")
    val height: Float = getPositiveFloat()

    println("The area of your triangle is 1/2*$base*$height = ${0.5*height*base}")
    println("==================================================================")

}

fun getPositiveFloat(): Float {
    var number: Float
    do {
        number = readLine()!!.toFloat()
        if (number <= 0) {
            print("Enter a positive number. Try again: ")
        }
    } while (number <= 0)

    return number
}
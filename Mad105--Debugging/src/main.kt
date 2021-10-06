import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {

    //var scanner = "" // to get user input

    val today = LocalDate.now() // to get current date / time

    // set date format
    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")

    // display today's date formatted
    val textToday = today.format(formatter)
    println("Today's date is: $textToday")

    // get info from user
    println("What month were you born in? (Enter as number: January = 1)")
    var myMonth: Int
    do {
        myMonth = readLine()!!.toInt()
        if ( (myMonth > 12) || (myMonth <= 0)) {
            println("Month out of range. Enter 1-12.")
        }
    } while ( (myMonth > 12) || (myMonth <= 0))

    println("What day were you born? ")
    var myDay: Int
    do {
        myDay = readLine()!!.toInt()
        if ( (myDay > 31) || (myDay <= 0)) {
            println("Day out of range. Enter 1-31.")
        }
    } while ( (myDay > 31) || (myDay <= 0) )

    val myYear = today.year// assign year to current year
    val thisMonth = today.monthValue
    val thisDay = today.dayOfMonth

    // assign information to variable birthday
    var birthday = LocalDate.of(myYear, myMonth, myDay)


    // if birthday already happened this year, add one to year
    if (!birthday.isAfter(today)) {
        birthday = birthday.plusYears(1)
    }


    val nextBirthday = birthday.format(formatter)
    // calculate days till next birthday

    val daysToBirthday = today.until(birthday, ChronoUnit.DAYS)

    if ( (myMonth == thisMonth) and (myDay == thisDay) ){
        println("Happy Birthday!")
    } else {
        println("Your next birthday is: $nextBirthday")
        println("There are $daysToBirthday days till your next birthday!")
    }

}
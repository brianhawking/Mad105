/********************************************************************
Mad 105 - Time to Full Moon

Programmer: Brian Veitch

Purpose:   Find the amount of time between current date and full moon.
 I create an array of full moon dates by adding multiples of 29 days, 12 hours, 44 minutes
 to the September 20, 2021, at 5:54pm full moon. I search through until
 I find a full moon date after the current date. Then calculate the time between
 *********************************************************************/


import java.time.format.DateTimeFormatter
//import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun main() {
    // how to format the time when displayed
    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

    val baseFullMoon = LocalDateTime.of(2021, 9, 20, 17, 54)

    // convert 29 days, 12 hours, 44 minutes to minutes
    val timeBetweenFullMoons = (29*24*60)+(12*60)+44

    // create an array of full moon dates
    var arrayOfFullMoons = emptyArray<LocalDateTime>()
    for (i in 0 .. 100) {
        arrayOfFullMoons += baseFullMoon.plus((i*timeBetweenFullMoons).toLong(), ChronoUnit.MINUTES)
    }

    val today = LocalDateTime.now()
    var timeUntil = 0L
    var nextFullMoon: LocalDateTime = today

    // find which full moon is next
    for (fullMoon in arrayOfFullMoons) {
        if (today.isBefore(fullMoon)) {
            timeUntil = today.until(fullMoon, ChronoUnit.DAYS)
            nextFullMoon = fullMoon
            break
        }
    }

    // display results
    println("Today's Date: ${today.format(formatter)}")
    println("The next full moon is $timeUntil days away on ${nextFullMoon.format(formatter)}")
    println("Wear silver or stay inside until ${nextFullMoon.plusDays(3).format(formatter)}")





}
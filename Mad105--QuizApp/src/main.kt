/********************************************************************
Mad 105 - Quiz App

Programmer: Brian Veitch

Purpose:   5 question quiz. User will answer the questions and their
 overall score will be displayed after.
 *********************************************************************/

fun main() {

    // Quiz questions with answers
    val questions = arrayOf(
        arrayOf("How many books are in the Harry Potter series?", "7"),
        arrayOf("Harry Dresden is a wizard of the white council and the winter ______? ", "knight"),
        arrayOf("In the book The Name of the Wind, Kvothe is a musician and member of the _____ ___  ", "Edema Ruh"),
        arrayOf("In the book Mistborn, an Allomancer must ingest what to gain magical powers? " , "Metal"),
        arrayOf("Who is the main villain in Lord of the Rings? ", "Sauron")
    )

    var userAnswers = arrayOf<String>()
    var questionsCorrect = 0


    // prompt user, check if answer is correct
    for (i in questions.indices) {
        print("${i+1}) ${questions[i][0]} ")
        userAnswers += readLine()!!.toString()

        if (userAnswers[i].compareTo(questions[i][1], ignoreCase = true) == 0) {
            println("======================")
            println("=======CORRECT========")
            println("======================\n")
            questionsCorrect += 1
        }
        else {
            println("======================")
            println("======INCORRECT=======")
            println("======================\n")
        }

    }

    println("\n======Overall Score======")
    println("===========${questionsCorrect}/5===========")
    println("=========================")


}
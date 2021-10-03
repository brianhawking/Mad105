/********************************************************************
Mad 105 - Advanced Classes App

Programmer: Brian Veitch

Purpose:   Create an Employee class and Enum PositionTitle. Display
employee info and calculate their weekly pay.
 *********************************************************************/

fun main() {

    // create three employees using Employee class
    var emp1 = Employee("Jane Doe", PositionTitle.ADMINISTRATION, true, 27.00, 1)
    var emp2 = Employee("Larry Jackson", PositionTitle.PRODUCTION, false, 22.00, 2)
    var emp3 = Employee("John Smith", PositionTitle.MAINTENANCE, false, 21.00, 3)

    // display employee information and calculate weekly pay
    emp1.display()
    emp1.calculate(45.0)

    emp2.display()
    emp2.calculate(50.0)

    emp3.display()
    emp3.calculate(35.0)


}
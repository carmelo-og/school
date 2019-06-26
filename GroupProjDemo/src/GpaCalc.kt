import java.util.Scanner

data class Subject(var name: String, var grade: Double, var credit: Double)
// Data classes are a concise way to create classes that just hold data.
// Compiler generates getters and setters for classes, as well as equals(), toString(), hashCode() and copy()

fun addSubject(list: MutableList<Subject>){
    print("Enter the class name: ")
    var userInName = readLine()
    print("Enter the letter grade (+/-): ")
    var userInGrade = parseGrade(readLine())

    print("Enter the number of credits: ")
    var userInCredit = readLine()?.toDoubleOrNull() // ? Safe call operator

    if (userInName == null || userInGrade == null || userInGrade == -1.0 || userInCredit == null){
        println("Invalid entry detected, try again.")
    } else{
        list.add(Subject(userInName, userInGrade, userInCredit))
    }
}
// In Kotlin, the type system distinguishes between references that can hold null (nullable references),
// and those that can not (non-null references).

fun editSubject(list: MutableList<Subject>){
    print("Enter the index to replace: ")
    var indexReplace = readLine()?.toIntOrNull()
    print("Enter the class name: ")
    var userInName = readLine()
    print("Enter the letter grade (no +/-): ")
    var userInGrade = parseGrade(readLine())

    print("Enter the number of credits: ")
    var userInCredit = readLine()?.toDoubleOrNull()

    if (indexReplace == null || userInName == null || userInGrade == null || userInGrade == -1.0 || userInCredit == null){
        println("Invalid entry detected, try again.")
    } else{
        try{
            list.set(indexReplace, Subject(userInName, userInGrade, userInCredit))
        }
        catch(e: java.lang.IndexOutOfBoundsException){
            println("Invalid index selected!")
        }
    }

}

fun showAllSubjects(list: MutableList<Subject>){
    for(x in list){
        println(x.toString()) // Data class utilizes built-in toString
    }
}


fun calcGpa(list: MutableList<Subject>){
    var totalCreditHours = 0.0
    val gradePoints: MutableList<Double> = ArrayList()
    for(x in list){
        totalCreditHours += + x.credit
        gradePoints.add(x.credit*x.grade)
    }
    var totalGradePoint = gradePoints.sum()/totalCreditHours
    println("Your total GPA is: " + totalGradePoint)
}

fun parseGrade(grade: String?): Double?{
    when (grade){
        "A+","a+" -> return 4.0
        "A","a" -> return 4.0
        "A-","a-" -> return 3.7
        "B+","b+" -> return 3.3
        "B","b" -> return 3.0
        "B-","b-" -> return 2.7
        "C+","c+" -> return 2.3
        "C","c" -> return 2.0
        "C-","c-" -> return 1.7
        "D+","d+" -> return 1.3
        "D","d" -> return 1.0
        "D-","d-" -> return 0.7
        "F","f" -> return 0.0
        else -> return -1.0
    }
}
// When matches its argument against all branches sequentially until some branch condition is satisfied.
// Essentially replaces the switch operator of C-like languages.

class GpaCalc(){
    fun main(){
        val list: MutableList<Subject> = ArrayList()
        var sc = Scanner(System.`in`)
        var userIn = -1;
        while (userIn != 0){
            println("GPA Calculator Menu:\n" +
                    "1) Add a class\n" +
                    "2) Edit a class\n" +
                    "3) Show all classes\n" +
                    "4) Calculate GPA\n" +
                    "0) Exit")
            userIn = sc.nextInt()
            when(userIn){
                0 -> {
                    println("Exiting..")
                    return
                }
                1 -> addSubject(list)
                2 -> editSubject(list)
                3 -> showAllSubjects(list)
                4 -> calcGpa(list)
            }
        }
    }
}
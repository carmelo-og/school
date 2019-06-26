import kotlin.system.exitProcess

class Main {
    fun main() {
        // Print menu options
        var mainMenuStr: String = ""
        mainMenuStr += "Select a tool\n" +
                "1) Fibonacci Generator\n" +
                "2) Power Set\n" +
                "3) Flashcards\n" +
                "4) GPA Calculator\n" +
                "0) Exit\n"

        while(true) {
            print(mainMenuStr)

            // Get user selection
            var stringInput: String = readLine()!!  // !! is the not-null assertion operator
            println("You entered: $stringInput") // $x or ${a + b} is string template to pass vars to string
            var input = stringInput.toInt()
            when (input) {
                0 -> exitProcess(0)
                1 -> Fib().main()
                2 -> PowerSetMain().main()
                3 -> FlashCardReader().main()
                4 -> GpaCalc().main()
                else -> { // Note the block
                    print("Invalid Selection")
                }
            }
        }
    }
}

fun main() {
    Main().main()
}

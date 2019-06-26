class Fib {
    fun main() {
        print("Enter the nth fibonacci number to generate up to: ")
        // Get user selection
        var stringInput: String = readLine()!!  // !! is the not-null assertion operator
        var n = stringInput.toInt()
        var t1 = 0
        var t2 = 1

        println("\nFibonacci Generator")
        print("The first $n fib numbers are: ")

        for (i in 1..n) {
            if(i == n)
                print("$t1")
            else
                print("$t1, ")

            val sum = t1 + t2
            t1 = t2
            t2 = sum
        }
        print("\n\n")
    }
}
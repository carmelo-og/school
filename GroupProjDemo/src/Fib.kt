class Fib {
    fun main() {
        val n = 10
        var t1 = 0
        var t2 = 1

        println("\nFibonacci Generator")
        print("First $n terms: ")

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
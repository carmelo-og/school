class PowerSet<T>(val items: List<T>) {
    private var set: IntArray = intArrayOf()
    init {
        println("Power set of $items is:")
        for (x in 0..items.size) {
            set = IntArray(x)
            getPowerSet(0, x)
        }
    }

    private fun getPowerSet(k: Int, x: Int) {
        if (k >= x) {
            println(set.map { items[it] })
        }
        else {
            for (j in 0 until items.size)
                if (k == 0 || j > set[k - 1]) {
                    set[k] = j
                    getPowerSet(k + 1, x)
                }
        }
    }
}

class PowerSetMain{
    fun main() {
        print("Enter csv of integers: ")
        // Get user selection
        var stringInput: String = readLine()!!  // !! is the not-null assertion operator
        var csv: List<String> = stringInput.split(",").map { it.trim() }
        val itemsList = listOf(csv)
        for (items in itemsList) {
            PowerSet(items)
            println()
        }
    }
}


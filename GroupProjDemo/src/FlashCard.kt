import java.io.File

class FlashCard {
    val question: String
    val answer: String
    var cardNum = FlashCardDeck.counter
    constructor(q: String, a: String) {
            question = q
            answer = a
            FlashCardDeck.addToCounter(1)
    }
    constructor() {
        print("Question for card $cardNum :")
        question = readLine()!!
        print("Answer for card $cardNum :")
        answer = readLine()!!
        FlashCardDeck.addToCounter(1)
    }
}

class FlashCardReader{
    fun main(){
        val cards: MutableList<FlashCard> = mutableListOf()
        var deckString: String = ""
        var counter: Int = 0
        println("1) Save to File\n2) Read from File ")
        // Get user selection
        var stringInput: String = readLine()!!  // !! is the not-null assertion operator
        var n = stringInput.toInt()
        when(n){
            1 ->    {FlashCardDeck.resetCounter()
                    while(n == 1){
                        cards.add(FlashCard())
                        println("1) Next\n2) Save to File ")
                        // Get user selection
                        stringInput = readLine()!!  // !! is the not-null assertion operator
                        n = stringInput.toInt()
                        deckString += cards[FlashCardDeck.counter-1].question + ":::" + cards[FlashCardDeck.counter-1].answer + "\n"
                    }
                File("flashcards.txt").writeText(deckString)
            }
            2 ->    {FlashCardDeck.resetCounter()
                    n = 1
                    File("flashcards.txt").forEachLine {
                        cards.add(FlashCard(it.split(":::")[0], it.split(":::")[1]))
                        }
                    println("${FlashCardDeck.counter} flashcards found!\n")
                    while(n == 1){

                        println("_Question: " + cards[counter].question + "\n")
                        println("1) See Answer\n2) Next ")
                        stringInput = readLine()!!  // !! is the not-null assertion operator
                        n = stringInput.toInt()
                        if (n == 1) {
                            println("\n_Answer: " + cards[counter].answer + "\n")
                        }
                        println("1) Next\n2) Finish ")
                        stringInput = readLine()!!  // !! is the not-null assertion operator
                        n = stringInput.toInt()
                        println()
                        counter = (counter+1)%(FlashCardDeck.counter)
                    }
                    }
            else -> println("")
        }
    }
}

object FlashCardDeck{
    var counter = 0
        private set
    init {
        counter = 1
    }
    @Synchronized fun addToCounter(num:Int) {
        counter += num
    }
    @Synchronized fun resetCounter() {
        counter = 0
    }
}
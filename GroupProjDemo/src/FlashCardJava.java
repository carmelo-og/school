import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class FlashCardDeckJava {
    private static int counter;
    public static final FlashCardDeckJava INSTANCE;
    public final int getCounter() {
        return counter;
    }
    public final synchronized void addToCounter(int num) {
        counter += num;
    }
    public final synchronized void resetCounter() {
        counter = 0;
    }
    private FlashCardDeckJava() {
    }
    static {
        FlashCardDeckJava var0 = new FlashCardDeckJava();
        INSTANCE = var0;
        counter = 1;
    }

public final class FlashCardReader {
    public final void main() {

        Scanner scanner = new Scanner(System.in);
        final List cards = (List)(new ArrayList());
        String deckString = "";
        int counter = 0;
        String stringInput = "1) Save to File\n2) Read from File ";
        System.out.println(stringInput);
        try {
            stringInput = scanner.nextLine();
        }
        catch (Exception e){
            System.out.println(e);
        }

        int n = Integer.parseInt(stringInput);
        switch(n) {
            case 1:
                FlashCardDeck.INSTANCE.resetCounter();

                while(n == 1) {
                    cards.add(new FlashCard());
                    System.out.println("1) Next\n2) Save to File ");
                    try {
                        stringInput = scanner.nextLine();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    n = Integer.parseInt(stringInput);
                    deckString = deckString + ((FlashCard)cards.get(FlashCardDeck.INSTANCE.getCounter() - 1)).getQuestion() + ":::" + ((FlashCard)cards.get(FlashCardDeck.INSTANCE.getCounter() - 1)).getAnswer() + "\n";
                }
                try {
                    FileWriter writer = new FileWriter("flashcards.txt");
                    writer.write(deckString);
                }
                catch (Exception e){
                    System.out.println(e);
                }

                break;
            case 2:
                FlashCardDeck.INSTANCE.resetCounter();
                n = 1;
                try {
                    FileReader reader = new FileReader("flashcards.txt");
                    reader.read();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                cards.add(new FlashCard());
                System.out.println(FlashCardDeck.INSTANCE.getCounter() + " flashcards found!\n");

                while(n == 1) {
                    System.out.println("_Question: " + ((FlashCard)cards.get(counter)).getQuestion() + "\n");
                    System.out.println("1) See Answer\n2) Next ");
                    try {
                        stringInput = scanner.nextLine();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    n = Integer.parseInt(stringInput);
                    if (n == 1) {
                        System.out.println("\n_Answer: " + ((FlashCard)cards.get(counter)).getAnswer() + "\n");
                    }

                    System.out.println("1) Next\n2) Finish ");
                    try {
                        stringInput = scanner.nextLine();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    n = Integer.parseInt(stringInput);
                    System.out.println();
                    counter = (counter + 1) % FlashCardDeck.INSTANCE.getCounter();
                }
                return;
            default:
                System.out.println();
        }

    }
}
// FlashCard.java


public final class FlashCard {

    private String question = "";
    private String answer = "";
    private int cardNum;
    public final String getQuestion() {
        return this.question;
    }
    public final String getAnswer() {
        return this.answer;
    }
    public final int getCardNum() {
        return this.cardNum;
    }
    public final void setCardNum(int var1) {
        this.cardNum = var1;
    }
    public FlashCard( String q,  String a) {
        this.cardNum = FlashCardDeck.INSTANCE.getCounter();
        this.question = q;
        this.answer = a;
        FlashCardDeck.INSTANCE.addToCounter(1);
    }

    public FlashCard() {
        Scanner scanner = new Scanner(System.in);
        this.cardNum = FlashCardDeck.INSTANCE.getCounter();
        String var1 = "Question for card " + this.cardNum + " :";
        System.out.print(var1);
        try {
            this.question = scanner.nextLine();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.print("Answer for card " + this.cardNum + " :");
        try {
            this.answer = scanner.nextLine();
        }
        catch (Exception e){
            System.out.println(e);
        }
        FlashCardDeck.INSTANCE.addToCounter(1);
    }
}
}

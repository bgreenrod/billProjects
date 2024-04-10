import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MemoryGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cards = new ArrayList<>();
        cards.add("A");
        cards.add("A");
        cards.add("B");
        cards.add("B");
        cards.add("C");
        cards.add("C");
        cards.add("D");
        cards.add("D");
        Collections.shuffle(cards);

        String[] board = new String[cards.size()];
        boolean[] flipped = new boolean[cards.size()];
        int pairsFound = 0;

        while (pairsFound < 4) {


            }
        }
    }
}

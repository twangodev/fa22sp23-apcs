package hw;

import java.util.Scanner;

// James Ding
public class GuessNum {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int random = (int) (Math.random() * 20 + 1); // Generate random number between 1-20 (inclusive)
        System.out.println("Generated a random number!");
        myGuesser(kb, random, 3);
    }

    public static void myGuesser(Scanner kb, int realNumber, int attempts) {
        if (attempts == 0) {
            System.out.println("You ran out of tries. The actual number was " + realNumber);
            return;
        }
        System.out.print("Enter a guess: ");
        int input = kb.nextInt();
        int difference = input - realNumber;
        if (difference == 0) {
            System.out.println("You are so smart.");
            return;
        } else if (difference > 0) {
            System.out.println("That was too big");
        } else { // difference < 0
            System.out.println("That was too small");
        }
        myGuesser(kb, realNumber, attempts - 1);
    }

}

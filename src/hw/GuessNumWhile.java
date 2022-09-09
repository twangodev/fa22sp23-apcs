package hw;

import java.util.Scanner;

public class GuessNumWhile {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int random = (int) (Math.random() * 20 + 1); // Generate random number between 1-20 (inclusive)
        System.out.println("Generated a random number!");
        while (true) {
            myGuesser(kb, random);
        }
    }

    public static void myGuesser(Scanner kb, int realNumber) {
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
    }

}

package hw;

import java.util.Scanner;

// James Ding
public class Wordle {

    final static String[] pool = {"JESUS", "WORLD", "BOBBY", "ADAMS", "EMILY"};
    private char[] chars;
    private int guessCount;

    public Wordle() {
        chars = pool[(int) (Math.random() * pool.length)].toCharArray();
        guessCount = 0;
    }

    public static void main(String[] args) {
        Wordle wordle = new Wordle();
        System.out.println("Welcome to Wordle!");

        Scanner kb = new Scanner(System.in);
        String guess;
        do {
            System.out.print("Attempt #" + ++wordle.guessCount + ". Enter your guess: ");
            guess = kb.nextLine().toUpperCase();
            System.out.println("Exact matches: " + wordle.exactMatch(guess));
            System.out.println("Any matches: " + wordle.anyMatch(guess));
        } while (wordle.exactMatch(guess) != wordle.chars.length);
        System.out.println("You win!");
    }

    public int exactMatch(String guess) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == guess.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int anyMatch(String guess) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < guess.length(); j++) {
                if (chars[i] == guess.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}

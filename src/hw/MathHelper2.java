package hw;

import java.util.Scanner;

// James Ding
public class MathHelper2 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to MathHelper2");
        System.out.print("Enter the lowest number: ");
        int lowBound = kb.nextInt();
        System.out.print("Enter the highest number (exclusive): ");
        int highBound = kb.nextInt();

        System.out.print("How many problems do you want to solve: ");
        int problemsToSolve = kb.nextInt();

        int amountCorrect = runGame(kb, problemsToSolve, lowBound, highBound);
        int percentage = (int) (((double) amountCorrect / problemsToSolve) * 100 + 0.5);
        System.out.println("You got " + percentage + "% correct");
    }

    /**
     * Generate a pseudo random numbers within the range [a, b)
     * @param a Lower limit for generation, inclusive
     * @param b Upper limit for generation, exclusive
     * @return A randomly generated number
     */
    public static int rng(int a, int b) {
        return (int) (Math.random() * (b - a) + a);
    }

    /**
     * Converts an operation id to String
     * @param id An integer from 0-3, representing the type of opereation
     * @return The string representation of an operation id
     */
    public static char getOperation(int id) {
        switch (id) {
            case 0: return '+';
            case 1: return '-';
            case 2: return '*';
            case 3: return '/';
            default: return ' ';
        }
    }

    /**
     * Produces the expected result of an operation
     * @param id An integer from 0-3, representing the type of operation
     * @param a The first input
     * @param b The second input
     * @return a id b
     */
    public static int getExpectedResult(int id, int a, int b) {
        switch (id) {
            case 0: return a + b ;
            case 1: return a - b;
            case 2: return a * b;
            case 3: return a / b;
            default: return 0;
        }
    }

    /**
     * Test interaction with user
     * @param kb Scanner
     * @param str The question prompt
     * @param expected Expected result
     * @return Whether the user answered correctly
     */
    public static boolean test(Scanner kb, String str, int expected) {
        System.out.print(str + " = ");
        String response;
        boolean cond = expected == kb.nextInt();
        if (cond) response = "Your answer is right";
        else response = "Your answer is wrong";
        System.out.println(response);
        return cond;
    }

    /**
     * Recursively run the game
     * @param kb Scanner
     * @param times Number of times to run game
     * @param lowBound Lower RNG bound, inclusive
     * @param highBound Upper RNG bound, exclusive
     * @return The amount of correct answers the user scored
     */
    public static int runGame(Scanner kb, int times, int lowBound, int highBound) {
        if (times < 1) return 0;

        int operation = rng(0, 4), firstNumber, secondNumber;
        char operator = getOperation(operation);

        do {
            firstNumber = rng(lowBound, highBound);
            secondNumber = rng(lowBound, highBound);
        }
        while (operation == 3 && secondNumber != 0 && firstNumber % secondNumber != 0);
        int expectedResult = getExpectedResult(operation, firstNumber, secondNumber), points = 0;

        if (test(kb, firstNumber + " " + operator + " " + secondNumber, expectedResult)) points = 1;
        return points + runGame(kb, times - 1, lowBound, highBound);
    }

}
package hw;

import java.util.Scanner;

// James Ding
public class MathHelper {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        test(kb, "5 + 6", 11);
        test(kb, "10 - 3", 7);
    }

    /**
     * Prompts a user to answer a math question and responds accordingly
     *
     * @param kb       Scanner
     * @param str      The string representation of an equation
     * @param expected The expected result
     */
    public static void test(Scanner kb, String str, int expected) {
        System.out.print(str + " = ");
        String response;
        if (expected == kb.nextInt()) response = "Your answer is right";
        else response = "Your answer is wrong";
        System.out.println(response);
    }

}

package hw;

import java.util.Scanner;

public class MathHelper {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        test(kb, "5 + 6", 11);
        test(kb, "10 - 3", 7);
    }

    public static void test(Scanner kb, String str, int expected) {
        System.out.print(str + " = ");
        String response;
        if (expected == kb.nextInt()) response = "Your answer is right";
        else response = "Your answer is wrong";
        System.out.println(response);
    }

}

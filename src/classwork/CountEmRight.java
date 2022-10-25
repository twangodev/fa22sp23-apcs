package classwork;

import java.util.Scanner;

// James Ding
public class CountEmRight {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.print("Type in a sentence and press ENTER. ");
            String input = kb.nextLine().toUpperCase();
            if (input.equals("EXIT")) {
                break;
            }

            String myString = input + " ";
            String[] sp = myString.split("S(\\s*)A");
            System.out.println("There are " + (sp.length - 1) + " occurrences.");

        }
    }

}

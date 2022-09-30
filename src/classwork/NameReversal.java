package classwork;

import java.util.Scanner;

// James Ding
public class NameReversal {

    /**
     * Reverses ones name
     * @param args Not used
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = kb.nextLine().toLowerCase();
        StringBuilder reversed = new StringBuilder();
        for (int i = name.length() - 1; i >= 0; i--) {
            reversed.append(name.charAt(i));
        }
        System.out.println(reversed);
    }

}

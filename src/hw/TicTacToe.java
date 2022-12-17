package hw;

import java.util.Scanner;

// James Ding
public class TicTacToe {

    /**
     * Converts a tic-tac-toe pattern onto a board
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the TicTacToe pattern: ");
        String input = kb.nextLine();

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(input.charAt((i * 3) + j) + " | ");
            }
            System.out.println();
        }
    }

}

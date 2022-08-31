package hw;

import java.util.Scanner;

public class GameMenu {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Welcome to the game menu! Select a game mode to begin");
        System.out.println("A: Local\nB: Online\nC: Local Area Network\nD: Exit");

        String input = kb.nextLine();
        switch (input) {
            case "A":
                System.out.println("You selected local");
                break;
            case "B":
                System.out.println("You selected online");
                break;
            case "C":
                System.out.println("You selected local area network");
                break;
            case "D":
                System.out.println("You selected exit");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}

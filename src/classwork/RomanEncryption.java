package classwork;

import java.util.Scanner;

// James Ding
public class RomanEncryption {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter global cipher offset: ");
        int offset = kb.nextInt();
        kb.nextLine();
        while (true) {
            System.out.print("Enter c for cipher, d for decipher: ");
            String mode = kb.nextLine();
            switch (mode.toLowerCase()) {
                case "c": {
                    System.out.print("Enter raw text: ");
                    String raw = kb.nextLine();
                    System.out.println(cipher(raw, offset));
                    break;
                }
                case "d": {
                    System.out.print("Enter cipher text: ");
                    String ciphered = kb.nextLine();
                    System.out.println(decipher(ciphered, offset));
                    break;
                }
                default: {
                    System.out.print("Input not recognized!");
                }
            }
        }
    }

    static String cipher(String raw, int offset) {
        StringBuilder response = new StringBuilder();
        String text = raw.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char myCharacter = text.charAt(i);
            if (!Character.isUpperCase(myCharacter)) continue;
            char cipheredChar = (char) ((((int) myCharacter - 65 + offset) % 26) + 65) ;
            response.append(cipheredChar);
        }
        return response.toString();
    }

    static String decipher(String text, int offset) {
        StringBuilder response = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char myCharacter = text.charAt(i);
            int rawCharIndex = ((int) myCharacter - 65 - offset) % 26;
            if (rawCharIndex < 0) rawCharIndex += 26;
            char cipheredChar = (char) (rawCharIndex + 65);
            response.append(cipheredChar);
        }
        return response.toString();
    }

}
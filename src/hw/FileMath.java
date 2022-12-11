package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// James Ding
public class FileMath {

    public static double parseOperation(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return (double) a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File(".\\mathdata.txt");
        if (!myFile.exists()) {
            System.out.println("File does not exist");
            return;
        }

        Scanner fileScanner = new Scanner(myFile);
        while (fileScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(fileScanner.nextLine());
            int a = lineScanner.nextInt();
            char operator = lineScanner.next().charAt(0);
            int b = lineScanner.nextInt();
            double result = parseOperation(a, b, operator);
            System.out.println(a + " " + operator + " " + b + " = " + result);
        }
    }

}

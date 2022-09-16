package hw;

import java.util.Scanner;

import static java.lang.Math.abs;

// James Ding
public class Combination {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter n, r: ");
        double n = kb.nextDouble();
        double r = kb.nextDouble();

        double nCr = 0.0;
        if (n >= r) { // nCr is 0 if n < r
            nCr = factorial(n) / (factorial(r) * factorial(n - r));
        }
        System.out.println("nCr: " + nCr);
    }

    public static double factorial(double n) {
        if (n < 0) return -factorial(abs(n)); // Negative factorial

        double running = 1.0;
        for (int i = 1; i < n + 1; i++) {
            running *= i;
        }
        return running;
    }

}

package classwork;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfFibonacci {

    public static int fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int size = kb.nextInt();

        int[] fib = new int[size];
        for (int i = 0; i < size; i++) {
            fib[i] = fibonacci(i);
        }
        System.out.println("The Fibonacci sequence is: " + Arrays.toString(fib));
    }

}

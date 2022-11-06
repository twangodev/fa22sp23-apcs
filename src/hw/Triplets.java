package hw;

import java.util.Arrays;
import java.util.Scanner;

// James Ding
public class Triplets {

    /**
     * Casts Math.pow to an int
     * @param base The base
     * @param exp The exponent
     * @return base^exp
     */
    public static int pow(int base, int exp) {
        return (int) Math.pow(base, exp);
    }

    /**
     * Concatenate two integer arrays
     * @param a The first array
     * @param b The second array
     * @return The concatenated array
     */
    public static int[] concatenate(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];

        // This is equivalent to System.arraycopy()
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            newArray[i + a.length] = b[i];
        }
        return newArray;
    }

    /**
     * Generate all possible triplets of a given length, recursively
     * @param limit The length of the triplets. Must be greater than 0
     * @return An array of all possible triplets
     */
    public static int[] generateTriplets(int limit) {
        if (limit < 1) return new int[0];
        int[] currentSet = {limit, pow(limit, 2), pow(limit, 3)};
        return concatenate(generateTriplets(limit - 1), currentSet);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the upper limit: ");
        int limit = kb.nextInt();

        int[] triplets = generateTriplets(limit);
        System.out.println("The triplets are:" + Arrays.toString(triplets));

    }

}

package hw;

// James Ding
public class Nim {

    public static int[] getSums(int[] piles) {
        int[] sums = new int[4];
        for (int pile : piles) {
            for (int i = 0; i < 4; i++) {
                int newIndexed = 1 << i; // Generates the value of a number with a single bit set to 1 at index i
                int andResult = pile & newIndexed; // Checks if the bit at index i is set to 1
                // If at least one of the bits is 1 (i.e. there was a one), add 1
                sums[i] += (andResult != 0) ? 1 : 0; // Use of a ternary operator
            }
        }
        return sums;
    }

}

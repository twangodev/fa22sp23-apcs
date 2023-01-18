package hw;

import java.util.Arrays;

// James Ding
public class Nim {

    final int[] piles;

    public Nim(int[] piles) {
        this.piles = piles;
    }

    public int[] getSums() {
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

    public int whichPile() {
        int bit = getSums().length - 1;
        while (getSums()[bit] % 2 == 0) {
            bit--;
        }
        for (int i = 0; i < piles.length; i++) {
            if (((piles[i] >> bit) & 1) == 1 ) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(piles);
    }
}

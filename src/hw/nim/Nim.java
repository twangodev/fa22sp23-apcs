package hw.nim;

import java.util.Arrays;

// James Ding
public class Nim {

    private static final int bitCount = 4;
    final int gameSize;
    int[] piles;

    /**
     * Constructor for NimPlayer. Note that this assumes the maximum number of stones in a pile is within 0..15
     * @param gameSize The maximum number of piles
     */
    public Nim(int gameSize) {
        this.gameSize = gameSize;
    }

    public int[] getSums(int[] piles) {
        int[] sums = new int[bitCount];
        for (int pile : piles) {
            for (int i = 0; i < bitCount; i++) {
                int newIndexed = 1 << i; // Generates the value of a number with a single bit set to 1 at index i
                int andResult = pile & newIndexed; // Checks if the bit at index i is set to 1
                // If at least one of the bits is 1 (i.e. there was a one), add 1
                sums[i] += (andResult != 0) ? 1 : 0; // Use of a ternary operator
            }
        }
        return sums;
    }

    public int badBit(int[] piles) {
        int bit = 0;
        int[] sums = getSums(piles);
        while (sums[bit] % 2 == 0 && bit < bitCount) {
            bit++;
        }
        return bit;
    }

    public int whichPile(int[] piles) throws IllegalStateException {

        this.piles = piles; // Store the piles for use in the howMany method

        int bit = badBit(piles);
        for (int i = 0; i < gameSize; i++) {
            int newIndexed = 1 << bit;
            int andResult = piles[i] & newIndexed;
            if (andResult != 0) {
                return i;
            }
        }

        // If there is no pile to select, return any pile that has a stone in it
        for (int i = 0; i < gameSize; i++) {
            if (piles[i] > 0) {
                return i;
            }
        }

        throw new IllegalStateException("There are no piles to select from");
    }

    public int howMany() {

        // Get the pile that was selected. Note that this does have a redundant pile setter, but it is necessary
        int selectedPileIndex = whichPile(piles);
        int badBit = badBit(piles);

        for (int i = piles[selectedPileIndex]; i > 0; i--) {

            int[] tempPiles = Arrays.copyOf(piles, piles.length);
            tempPiles[selectedPileIndex] -= i;
            int[] tempSum = getSums(tempPiles);

            for (int j = 0; j < bitCount; j++) {
                if (tempSum[j] % 2 != 0) {
                    break;
                }
                if (badBit == j) return i;
            }
        }

        return 0;
    }

}

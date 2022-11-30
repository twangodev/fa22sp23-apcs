package hw.stones;

import java.util.Arrays;
import java.util.stream.IntStream;

// James Ding
public class StonesGame {

    static final int maxTake = 3;
    static final int[] possibleTakes = IntStream.rangeClosed(1, maxTake).toArray();

    StonesPlayer p1, p2;
    int stoneCount;
    boolean announcePlays;
    StonesPlayer previous = null;

    public StonesGame(StonesPlayer p1, StonesPlayer p2, int initialStones, boolean announcePlays) {
        this.p1 = p1;
        this.p2 = p2;
        stoneCount = initialStones;
        this.announcePlays = announcePlays;
    }

    public static boolean validTake(int take) {
        return Arrays.binarySearch(possibleTakes, take) >= 0;
    }

    public void announce(String s) {
        if (announcePlays) {
            System.out.println(s);
        }
    }

    /**
     * Simulates the game of stones with the two players
     * @return The respective winner of the game
     */
    public void play() {
        announce("There are currently " + stoneCount + " stones left.");
        int take;
        if (previous == p1) {
            announce( p2.name + " is up.");
            take = p2.move(this);
            announce(p2.name + " takes " + take + " stones");
            previous = p2;
        } else {
            announce(p1.name + " is up.");
            take = p1.move(this);
            announce(p1.name + " takes " + take + " stones");
            previous = p1;
        }
        stoneCount -= take;
    }

    public static void main(String[] args) {
        StonesPlayer p1 = new ShenStones();
        StonesPlayer p2 = new DingStones();
        StonesGame game = new StonesGame(p1, p2, 23, true);
        while (game.stoneCount > 0) {
            game.play();
        }

        if (game.previous == p1) {
            System.out.println(p2.name + " wins!");
        } else {
            System.out.println(p1.name + " wins!");
        }

    }

    public static StonesGame copy(StonesGame game, boolean announcePlays) {
        StonesGame gameCopy = new StonesGame(game.p1, game.p2, game.stoneCount, announcePlays);
        gameCopy.previous = game.previous;
        return gameCopy;
    }

}

package hw.stones;

import java.util.Scanner;
public class HumanStones extends StonesPlayer {

    public HumanStones(String str) {
        super(str);
    }

    @Override
    public int move(StonesGame game) {
        Scanner kbInput = new Scanner (System.in);
        int user;
        while (true) {
            System.out.print("How many stones do you want to take? ");
            user = kbInput.nextInt();
            if (StonesGame.validTake(user)) break;
            System.out.println("Invalid input. Please try again.");
        }
        return user;
    }

}

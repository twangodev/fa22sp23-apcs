package hw.nim;

import java.util.Arrays;
import java.util.Scanner;

public class NimGame {

    public static void main (String[] ags) {
        Scanner kb = new Scanner(System.in);
        System.out.print("How many piles? ");
        int nps = kb.nextInt();
        int[] piles = new int[nps];
        int[] temPiles;
        Nim[] player = new Nim[2];
        player[0] = new Nim (nps);
        player[1] = new Nim (nps);
        String msg;
        for (int i = 0; i < nps; i++) {
            piles[i]=(int) (Math.random()*15 + 1);
        }
        int cur = 0;
        do {
            temPiles = Arrays.copyOf(piles, nps);
            System.out.println(Arrays.toString(temPiles));
            int pc = player[cur].whichPile(temPiles);
            int nc = player[cur].howMany();
            if (!check(piles, pc, nc)) {
                msg = player[cur] + " lost by illegal move!";
                break;
            }
            System.out.println (player[cur] + " took " + nc + " from Pile-" + pc);
            piles[pc] -= nc;
            if (gameOver(piles)) {
                msg = player[cur] + " won!";
                break;
            }
            cur = 1 - cur;
        } while (true);
        System.out.println(msg);
        kb.close();
    }

    private static boolean check(int[] piles, int pc1, int nc1) {
        return pc1 >= 0 && pc1 < piles.length && piles[pc1] >= nc1;
    }

    private static boolean gameOver(int[] piles) {
        int sum = 0;
        for (int p : piles) sum += p;
        return sum == 0;
    }

}

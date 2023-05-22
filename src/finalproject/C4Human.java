package finalproject;

import info.gridworld.grid.Location;

import java.awt.*;

public class C4Human extends C4Player {

    public C4Human(Color c, Color cc, String n, C4Board b) {
        super(c, cc, n, b);
    }

    public boolean isHuman() {
        return true;
    }

    public int move(int level) {
        return 0;
    }

    public boolean addPiece(int col, int player) {
        return true;
    }

    public void removePiece(int col) {
        return;
    }

    public int check(int lastPlayer, int level) {
        return 0;
    }

    public int evaluate(int player) {
        return 0;
    }

    public int countOpens(Location loc, int dir) {
        return 0;
    }

}

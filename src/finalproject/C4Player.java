package finalproject;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

public abstract class C4Player {

    public static final int MACHINE = 0;
    public static final int HUMAN = 1;
    public Color[] playerColor;
    public String name;
    protected C4Board board;

    // Constructor: c is my color, cc is opponent's color, n is name, b is board
    public C4Player(Color c, Color cc, String n, C4Board b) {
        playerColor = new Color[2];
        playerColor[0] = c;
        playerColor[1] = cc;
        name = n;
        board = b;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return playerColor[0];
    }

    public Color getOpColor() {
        return playerColor[1];
    }

    /**
     * Count the number of pieces of the same color in a row of the given
     * direction
     *
     * @param loc: the starting location
     * @param dir: the direction to check
     * @return the number of connected pieces
     */
    public int countPieces(Location loc, int dir) {
        Grid<Actor> gr = board.getGrid();
        Color c = gr.get(loc).getColor();
        Location next = loc.getAdjacentLocation(dir);
        if (!gr.isValid(next) || gr.get(next) == null
                || !gr.get(next).getColor().equals(c)) {
            return 1;
        }
        return 1 + countPieces(next, dir);
    }

    // return the choice of column, given millisecond allowed
    public abstract int move(int millis);

    // return if self is a human
    public abstract boolean isHuman();

}

package finalproject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

public class C4Board extends ActorWorld {

    private final int millis = 10000;
    private C4Player[] player;
    private int current;
    private boolean gameOver = false;
    private boolean anyFalling = false;

    /**
     * Constructor
     */
    public C4Board() {
        super(new BoundedGrid<>(6, 7));
    }

    public void initialize(C4Player p1, C4Player p2) {
        player = new C4Player[2];
        player[0] = p1;
        player[1] = p2;
        current = 0;
        whoseTurn();
    }

    /**
     * Display the current player
     */
    private void whoseTurn() {
        setMessage("Time for " + player[current].getName());
    }

    @Override
    /*
     * The control of the game: provides the falling of a game piece, the
     * cheching of the winner, and let players take turns
     */
    public void step() {
        C4Piece p;
        anyFalling = false;
        if (gameOver) {
            return;
        }
        Grid<Actor> gr = getGrid();
        for (Location loc : gr.getOccupiedLocations()) {// let a piece fall
            p = (C4Piece) gr.get(loc);
            if (p.isFalling()) {
                p.act();
                anyFalling = true;
            }
        }
        if (anyFalling) {
            return;
        }
        if (!checkWinner()) {
            if (player[current].isHuman()) return;
            long currentTime = System.currentTimeMillis();
            int col = player[current].move(millis);
            int duration = (int) (System.currentTimeMillis() - currentTime);
            C4Piece piece = new C4Piece(player[current].getColor());
            Location newLoc = new Location(0, col);
            if (duration > millis) {
                setMessage("Over time limit! Winner is " + player[1 - current].getName());
                gameOver = true;
            } else if (getGrid().get(newLoc) == null) {
                add(newLoc, piece);
                current = 1 - current;
                whoseTurn();
            } else { // illegal move
                setMessage("Illegal move! Winner is " + player[1 - current].getName());
                gameOver = true;
            }

        }
    }

    /**
     * Count the number of pieces of the same color in a row of the given
     * direction
     *
     * @param loc: the starting location
     * @param dir: the direction to check
     * @return the number of connected pieces
     */
    private int countPieces(Location loc, int dir) {
        Grid<Actor> gr = getGrid();
        Color c = gr.get(loc).getColor();
        Location next = loc.getAdjacentLocation(dir);
        if (!gr.isValid(next) || gr.get(next) == null
                || !gr.get(next).getColor().equals(c)) {
            return 1;
        }
        return 1 + countPieces(next, dir);
    }

    /**
     * Winner checker: four directions only, to avoid any
     *
     * @return true if a winner; gameOver is updated
     */
    private boolean checkWinner() {
        Grid<Actor> gr = getGrid();
        for (Location loc : gr.getOccupiedLocations()) {
            for (int dir = 0; dir < 180; dir += 45) { // check only 4 directions
                int connected = countPieces(loc, dir);
                if (connected == 4) {
                    gameOver = true;
                    setMessage("Game Over! The winner is: " + player[1 - current].getName());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean keyPressed(String description, Location loc) {
        if (!gameOver && !anyFalling && player[current].isHuman()) {
            int key = Integer.parseInt(description);
            if (key >= 1 && key <= 7) {
                C4Piece piece = new C4Piece(player[current].getColor());
                Location newLoc = new Location(0, key - 1);
                if (getGrid().get(newLoc) == null) {
                    add(newLoc, piece);
                    current = 1 - current;
                    whoseTurn();
                } else {
                    setMessage("Select a column that is not FULL!");
                }
            }
        }
        return true;
    }

}

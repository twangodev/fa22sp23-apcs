package finalproject;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

public class C4Piece extends Actor {

    private boolean isFalling = true;

    public C4Piece(Color c) {
        setColor(c);
    }

    public boolean isFalling() {
        return isFalling;
    }

    @Override
    public void act() {
        if (!isFalling) return;
        Grid<Actor> gr = getGrid();
        Location down = getLocation().getAdjacentLocation(Location.SOUTH);
        if (gr.isValid(down) && gr.get(down) == null) {
            moveTo(down);
        } else {
            isFalling = false;
        }
    }

}

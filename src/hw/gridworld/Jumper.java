package hw.gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * 1. Name three properties of every actor.
 * Color, direction, and location, as well as a reference to a grid
 * 2. When an actor is constructed, what is its direction and color?
 * Blue, north
 * 3. Why do you think that the <code>Actor</code> class was created as a class instead of an interface?
 * Interfaces cannot contain instance variables, and the Actor class needs to store a reference to a grid
 * 4. Can an actor put itself into a grid twice without first removing itself? Can an actor remove itself from a grid
 * twice? Can an actor be placed into a grid, remove itself, and then put itself back? Try it out. What happens?
 * No IllegalStateException is thrown. No. IllegalStateException is thrown, Yes
 * 5. How can an actor turn 90 degrees to the right
 */
public class Jumper extends Actor {

    public boolean canJumpOverActor(Actor a) {
        return a == null || a instanceof Flower || a instanceof Rock;
    }

    public boolean canJump() {
        Grid<Actor> g = getGrid();
        if (g == null) return false;

        int direction = getDirection();
        Location current = getLocation();
        Location next = current.getAdjacentLocation(direction);
        Actor nextNeighbor = g.get(next);
        Location next2 = next.getAdjacentLocation(direction);
        Actor next2Neighbor = g.get(next2);

        return g.isValid(next) && g.isValid(next2) && canJumpOverActor(nextNeighbor) && canJumpOverActor(next2Neighbor);
    }

    public void jump() {
        Grid<Actor> g = getGrid();
        if (g == null) return;

        Location current = getLocation();
        int direction = getDirection();
        Location next = current.getAdjacentLocation(direction);
        Location next2 = next.getAdjacentLocation(direction);

        if (g.isValid(next2)) moveTo(next2);
        else removeSelfFromGrid();
    }


    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void act() {
        if (canJump()) jump();
        else turn();
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        Jumper bug = new Jumper();
        world.add(bug);
        world.show();
    }

}

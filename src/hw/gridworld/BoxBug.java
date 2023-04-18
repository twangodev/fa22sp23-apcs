package hw.gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

public class BoxBug extends Bug {

    private int steps;
    private final int sideLength;

    public BoxBug(int length) {
        steps = 0;
        sideLength = length;
    }

    @Override
    public void act() {
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else {
            turn();
            turn();
            steps = 0;
        }
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        BoxBug bug = new BoxBug(3);
        world.add(bug);
        world.show();
    }

}

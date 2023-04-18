package hw.gridworld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {

    private int steps;
    private int sideLength;

    public SpiralBug(int length) {
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
            sideLength++;
        }
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        SpiralBug bug = new SpiralBug(3);
        world.add(bug);
        world.show();
    }

}

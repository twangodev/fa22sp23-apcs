package classwork.chameleon;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonCritter extends Critter {

    public void processActors(ArrayList<Actor> actors) {
        if (actors.size() == 0) setColor(getColor().darker());
    }

    public void makeMove(Location loc) {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new ChameleonCritter());
        world.add(new Rock());
        world.show();
    }

}

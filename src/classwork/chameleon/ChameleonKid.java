package classwork.chameleon;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

    @Override
    public void processActors(ArrayList<Actor> actors) {
        boolean frontBehind = false;
        for (Actor a : actors) {
            Location loc = a.getLocation();
            int forward = getDirection();
            int behind = (getDirection() + 180) % 360;
            if (loc.equals(getLocation().getAdjacentLocation(forward)) || loc.equals(getLocation().getAdjacentLocation(behind))) {
                frontBehind = true;
                break;
            }
        }
        if (frontBehind) super.processActors(actors);
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        world.add(new ChameleonKid());
        world.add(new Rock());
        world.show();
    }

}

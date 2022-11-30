package hw.stones;

// James Ding
public abstract class StonesPlayer {

    String name;

    public StonesPlayer(String name) {
        this.name = name;
    }

    abstract public int move(StonesGame game);

}

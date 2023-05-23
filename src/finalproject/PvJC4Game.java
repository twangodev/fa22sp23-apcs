package finalproject;

import java.awt.*;

public class PvJC4Game {

    public static void main(String[] args) {
        C4Board c4b = new C4Board();
        C4Player p1 = new C4Human(Color.BLUE, Color.RED, "Player1", c4b);
        C4Player p2 = new C4James(Color.RED, Color.BLUE, "James AI", c4b, 5);
        c4b.initialize(p1, p2);
        c4b.show();
    }

}

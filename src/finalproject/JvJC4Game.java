package finalproject;

import java.awt.*;

public class JvJC4Game {

    public static void main(String[] args) {
        C4Board c4b = new C4Board();
        C4Player p1 = new C4James(Color.BLUE, Color.RED, "James AI 1", c4b, 5);
        C4Player p2 = new C4James(Color.RED, Color.BLUE, "James AI 2", c4b, 5);
        c4b.initialize(p1, p2);
        c4b.show();
    }

}

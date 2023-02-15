package classwork.singer;

import java.util.ArrayList;

public class Choir {

    public ArrayList<Singer> singers = new ArrayList<>();

    public void allSing() {
        for (Singer singer : singers) {
            singer.sing();
        }
    }

}

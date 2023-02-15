package classwork.singer;

import classwork.singer.Singer;

public class Soprano extends Singer {

    public Soprano(String name) {
        super(name);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void sing() {
        System.out.println("lalala");
    }

}

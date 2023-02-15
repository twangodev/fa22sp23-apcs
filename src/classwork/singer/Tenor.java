package classwork.singer;

public class Tenor extends Singer {

    public Tenor(String name) {
        super(name);
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void sing() {
        System.out.println("bebepoo");
    }

}

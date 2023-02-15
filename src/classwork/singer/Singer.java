package classwork.singer;

public abstract class Singer {

    public String name;

    public Singer(String name) {
        this.name = name;
    }

    public abstract void sing();

}

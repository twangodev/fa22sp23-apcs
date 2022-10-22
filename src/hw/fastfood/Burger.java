package hw.fastfood;

// James Ding
public class Burger extends Item {

    private final int patties;

    public int getPatties() {
        return patties;
    }

    public Burger(int patties, double price, double calories) {
        super(price, calories);
        this.patties = patties;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "patties=" + patties +
                ", double=" + getPrice() +
                ", calories" + getCalories() +
                '}';
    }

}

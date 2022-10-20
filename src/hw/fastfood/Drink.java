package hw.fastfood;

public class Drink extends Item {

    private final char size;

    public Drink(char size, double price, double calories) {
        super(price, calories);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size=" + size +
                ", double=" + getPrice() +
                ", calories" + getCalories() +
                '}';
    }

}

package hw.fastfood;

import java.util.List;

public class Meal {

    private final Item burger, drink, side;

    public Meal(Burger burger, Drink drink, Side side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    public double getTotalPrice() {
        return burger.getPrice() + drink.getPrice() + side.getPrice();
    }

    public double getTotalCalories() {
        return burger.getCalories() + drink.getCalories() + side.getCalories();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "burger=" + burger +
                ", drink=" + drink +
                ", side=" + side +
                '}';
    }
}

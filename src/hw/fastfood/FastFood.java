package hw.fastfood;

public class FastFood {

    public static void main(String[] args) {

        Burger doubleDouble = new Burger(2, 4.04, 670);
        Drink coke = new Drink('L', 2.16, 270);
        Side fries = new Side(1.87, 370);

        Meal combo = new Meal(doubleDouble, coke, fries);

        System.out.println("Double Double: " + doubleDouble);
        System.out.println("Coke: " + coke);
        System.out.println("Fries: " + fries);

        System.out.println("Combo: " + combo);
        System.out.println("Combo Price: $" + combo.getTotalPrice() + "\nCombo Calories: " + combo.getTotalCalories());

    }

}

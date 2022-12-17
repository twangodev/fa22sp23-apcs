package hw.fastfood;

// James Ding
public class FastFood2 {

    public static Item randomSelectItem(Item[] items) {
        int randIndex = (int) (Math.random() * (items.length - 1));
        return items[randIndex];
    }

    public static void main(String[] args) {

        Burger hamburger = new Burger(1, 2.10, 390);
        Burger cheeseBurger = new Burger(1, 2.40, 480);
        Burger doubleDouble = new Burger(2, 3.45, 670);
        Burger[] burgers = {hamburger, cheeseBurger, doubleDouble};

        Drink small = new Drink('S', 1.50, 210);
        Drink medium = new Drink('M', 1.65, 260);
        Drink large = new Drink('L', 1.85, 310);
        Drink xlarge = new Drink('X', 2.05, 380);
        Drink shake = new Drink('M', 2.15, 590);
        Drink[] drinks = {small, medium, large, xlarge, shake};

        Side fries = new Side(1.87, 370);

        Meal[] meals = new Meal[10];

        double cost = 0;
        double calories = 0;

        System.out.println("Randomly generated meals:");
        for (int i = 0; i < meals.length; i++) {
            Meal generatedMeal = new Meal((Burger) randomSelectItem(burgers), (Drink) randomSelectItem(drinks), fries);
            System.out.println("\t" + generatedMeal);
            cost += generatedMeal.getTotalPrice();
            calories += generatedMeal.getTotalCalories();
            meals[i] = generatedMeal;
        }
        System.out.format("The cost of all the meals is $%.2f%n", cost);
        System.out.format("The total calories of all the meals is %,.0f%n", calories);


    }

}

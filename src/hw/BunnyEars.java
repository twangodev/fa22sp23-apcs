package hw;

// James Ding
public class BunnyEars {

    /**
     * Counts the amount of bunny ears recursively
     * Each third bunny is a naughty bunny, and will only have one ear
     *
     * @param n The amount of bunnies in the line
     * @return The amount of ears that should be up
     */
    static int countEars(int n) {
        if (n == 0) return 0;
        if (n % 3 == 0) return 1 + countEars(n - 1);
        return 2 + countEars(n - 1);
    }

}

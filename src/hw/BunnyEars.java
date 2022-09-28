package hw;

// James Ding
public class BunnyEars {

    static int countEars(int n) {
        if (n == 0) return 0;
        if (n % 3 == 0) return 1 + countEars(n - 1);
        return 2 + countEars(n - 1);
    }

}

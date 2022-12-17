package quiz;

// James Ding
public class FRQ1 {

    static double findAverage(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int randomNumber = (int) (Math.random() * 91 + 10);
            sum += randomNumber;
        }
        return (double) sum / n;
    }

}

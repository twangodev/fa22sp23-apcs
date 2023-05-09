package quiz;

public class MCPractice {

    public static void question1() {
        // Which of the following statements sets numDots to a random number between 1 and 6?
        int numDots = (int) (Math.random() * 6) + 1;
    }

    public static void question2() {
        // In the CrapsGame class, point is a field and not a local variable in the nextRoll method. Why?
        // Because the Craps class needs to refer to a point
    }

    public static int question3() {
        // What is the value of x after the following code executed?

        int x = 1;
        switch (x) {
            case 1 -> x++;
            case 2 -> x += 2;
            default -> x = 0;
        }

        return x;
    }

    public static void question4() {
        /*
        double d = p* p - 4 * q;
        if (d >= 0.0 && Math.sqrt(d) - p > 0.0) {
            System.out.println("Has a positive root");
        }
        */
        // Run-time exception when and only when d < 0
    }

    public static boolean question5(int x, int y) {
        // Which of the following expressions is equivalent to
        return (x < 2.5 && y >= 3) == !(x >= 2.5 || y < 3);
    }

    public static int question6(int n) {
        /*
        Consider the following algorithm:

        Input: n
        c = 0
        Repeat the following two steps while n > 1:
        n = n / 3
        c = c + 1
        Output: c
        What is its output when n = 50?
        */
        int c = 0;
        while (n > 1) {
            n /= 3;
            c++;
        }
        return c;
    }

    public static void question7(int n) {
        if (n == 0) return;
        question7(n / 2);
        System.out.print(n % 2);
    }

    public static void question8() {
        System.out.println("1" + 2 + 3);
    }

    public static boolean question9(boolean a, boolean b) {
        return (!a && b) == !(a || b);
    }

    public static class Year2016 {
        public String toString() { return "2016"; }
    }

    public static class Test2016 extends Year2016 {
        public void print() {
            System.out.println(new Year2016());
            System.out.println(new Test2016());
            System.out.println(this);
        }
    }

    public static void question10() {
        new Test2016().print();
    }

    public static int question11() {
        int n = 2016;
        for (int i = 0; i < 50; i++) {
            n = (n + 2) / 2;
        }
        return n;
    }

    public static int question12() {
        double x = 5, y = 2;
        return (int)(x + y + x / y - x * y - x / (10 * y));
    }

    public static class Particle {

        private double velocity;

        public double getVelocity() {
            return velocity;
        }

        public void setVelocity(double velocity) {
            this.velocity = velocity;
        }

        public void hit(Particle p) {
            // I.
            double v = getVelocity();
            setVelocity(p.getVelocity());
            p.setVelocity(v);
            // 2.
            v = velocity;
            velocity = p.getVelocity();
            p.setVelocity(v);
            // 3.
            v = velocity;
            // velocity = p.velocity();
            p.velocity = v;
        }
    }

    public static int question14(int x) {
        if (x < 100) {
            x = question14(x + 10);
        }
        return x - 1;
    }

    public static boolean question15Helper(int y, int x) {
        return !(y < (double) (3 * x) / 4);
    }

    public static void question15(int x) {
        int y1 = 3 * x / 4;
        if (y1 < 3 * x / 4) y1++;

        int y2 = 1;
        while (y2 < 3 * x / 4) y2++;

        int y3 = 2010 - (int) (2010 - x * 3 / 4);

        System.out.println(question15Helper(y1, x));
        System.out.println(question15Helper(y2, x));
        System.out.println(question15Helper(y3, x));
    }

    public static void main(String[] args) {
        question1();
        question2();
        System.out.println(question3());
        question4();
        System.out.println(question5((int) (Math.random() * 10), (int) (Math.random() * 10)));
        System.out.println(question6(50));
        question7(12);
        question8();
        System.out.println();
        System.out.println(question9(true, true));
        question10();
        System.out.println(question11());
        System.out.println(question12());
        System.out.println(question14(60));
        question15(1);
    }

}

package hw;

// James Ding
public class Fraction {

    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static void main(String[] args) {
        Fraction f = new Fraction(2, 5);
        System.out.println(f.eval());
        System.out.println(f.add(new Fraction(3, 7)));
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double eval() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction fraction) {
        int num = numerator * fraction.denominator + denominator * fraction.numerator;
        int gcd = denominator * fraction.denominator;
        return new Fraction(num, gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}

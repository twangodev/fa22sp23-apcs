package classwork;

// James Ding
public class Circle {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the circumference of a circle
     *
     * @return 2 * pi * radius
     */
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates the area of a circle
     *
     * @return pi * radius ^ 2
     */
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

}

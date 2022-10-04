package hw.rectangle;

// James Ding
public class Rectangle {

    private double length, width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Initialize an empty rectangle instance
     */
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    /**
     * Initialize a rectangle with length and width
     * @param length Length of the rectangle
     * @param width Width of the rectangle
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Returns the perimeter of the rectangle
     * @return 2 * l + 2 * w
     */
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /**
     * Returns the area of the rectangle
     * @return l * w
     */
    public double getArea() {
        return length * width;
    }

}

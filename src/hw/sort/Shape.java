package hw.sort;

public class Shape implements Comparable<Shape> {

    private final double area;

    public Shape(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(area, o.getArea());
    }

    @Override
    public String toString() {
        return "Shape{" + "area=" + area + '}';
    }

}

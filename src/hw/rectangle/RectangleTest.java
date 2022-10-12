package hw.rectangle;

// James Ding
public class RectangleTest {

    public static void main(String[] args) {
        Rectangle square = new Rectangle(1,1);
        System.out.println("Perimeter of a 1x1 square: " + square.getPerimeter());
        System.out.println("Area of a 1x1 square: " + square.getArea());

        square.setWidth(2);
        square.setLength(2);

        System.out.println("Perimeter of a 2x2 square: " + square.getPerimeter());
        System.out.println("Area of a 2x2 square: " + square.getArea());

        Rectangle myRectangle = new Rectangle();
        myRectangle.setLength(3);
        myRectangle.setWidth(10);

        System.out.println("Perimeter of a 3x10 rectangle: " + myRectangle.getPerimeter());
        System.out.println("Area of a 3x10 rectangle: " + myRectangle.getArea());

        System.out.println(myRectangle);
        System.out.println(myRectangle.equals(new Rectangle(3, 10))); // true

    }

}

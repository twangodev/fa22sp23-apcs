package hw.sort;

import java.util.Arrays;

public class Sorting {

    public static Shape[] insertSortShapes(Shape[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Shape element = arr[i];
            for (int j = i - 1; j>= 0; j--) {
                if (element.compareTo(arr[j]) < 0) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = element;
                    break;
                }
                if (j == 0) {
                    arr[j] = element;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new Shape(Math.random() * 100);
        }
        System.out.println("Unsorted: " + Arrays.toString(shapes));
        System.out.println("Sorted: " + Arrays.toString(insertSortShapes(shapes)));

    }

}

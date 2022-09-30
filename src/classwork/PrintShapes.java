package classwork;

// James Ding
public class PrintShapes {

    public static void main(String[] args) {
        printTriangle('#', 5);
        System.out.println();
        printParallelogram('$', 5, 7);
    }

    /**
     * Prints a character a specified amount of times on a single line
     * @param ch The character to print
     * @param amount The amount of times to print
     */
    static void printSigns(char ch, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(ch);
        }
    }

    /**
     * Prints a space a specified amount of times on a single line
     * @param amount The amount of times to print the space
     */
    static void printWhitespace(int amount) {
        printSigns(' ', amount);
    }

    /**
     * Prints a parallelogram with the specific character, height, and length
     * @param ch The character the shape should be filled with
     * @param height The height of the parallelogram
     * @param length The length of the parallelogram
     */
    static void printParallelogram(char ch, int height, int length) {
        for (int i = 0; i < height; i++) {
            printWhitespace(height - i);
            printSigns(ch, length);
            System.out.println();
        }
    }

    /**
     * Prints a triangle with the specified character and height
     * @param ch The character the shape should be filled with
     * @param height The height of the triangle
     */
    static void printTriangle(char ch, int height) {
        for (int i = 0; i < height; i++) {
            printWhitespace(height - i);
            printSigns(ch, (i * 2) + 1);
            System.out.println();
        }
    }

}

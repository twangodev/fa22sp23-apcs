package classwork;

// James Ding
public class PrintShapes {

    public static void main(String[] args) {
        printTriangle('#', 5);
        System.out.println();
        printParallelogram('$', 5, 7);
    }

    static void printSigns(char ch, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(ch);
        }
    }

    static void printWhitespace(int amount) {
        printSigns(' ', amount);
    }

    static void printParallelogram(char ch, int height, int length) {
        for (int i = 0; i < height; i++) {
            printWhitespace(height - i);
            printSigns(ch, length);
            System.out.println();
        }
    }

    static void printTriangle(char ch, int height) {
        for (int i = 0; i < height; i++) {
            printWhitespace(height - i);
            printSigns(ch, (i * 2) + 1);
            System.out.println();
        }
    }

}

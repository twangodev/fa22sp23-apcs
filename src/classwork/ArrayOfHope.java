package classwork;

// James Ding
public class ArrayOfHope {

    public static void main(String[] args) {

        int low = 65;
        int high = 90;

        char[] ch = new char[high - low + 1];
        for (int i = low; i < high + 1; i++) {
            ch[i - low] = (char) i;
        }

        for (char c : ch) {
            System.out.print(c + ", ");
        }

    }

}

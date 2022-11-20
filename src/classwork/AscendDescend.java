package classwork;

// James Ding
public class AscendDescend {

    public static String[] sort(String[] array) {
        String[] sorted = new String[array.length];
        System.arraycopy(array, 0, sorted, 0, array.length);
        for (int i = 0; i < sorted.length; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i].compareTo(sorted[j]) > 0) {
                    String temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public static String[] reverse(String[] array) {
        String[] reversed = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - i - 1];
        }
        return reversed;
    }

    public static void main(String[] args) {
        String[] ss = new String[] {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin", "Benard", "Erza", "Herman"};
        String[] sorted = sort(ss);
        String[] reversed = reverse(sorted);

        System.out.format("%-10s %-10s\n\n", "Ascend", "Descend");
        for (int i = 0; i < ss.length; i++) {
            System.out.format("%-10s %-10s\n", sorted[i], reversed[i]);
        }
    }

}

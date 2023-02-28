package hw;

import java.util.Arrays;

public class BigOBinary {

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        int target = arr[(int) (Math.random() * arr.length)];
        System.out.println("Target: " + target);

        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;
        while (start <= end) {
            if (target == arr[middle]) {
                System.out.println("Index: " + middle);
                break;
            } else if (target < arr[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }

        System.out.println("Binary search is a O(log n) algorithm.");
    }

}

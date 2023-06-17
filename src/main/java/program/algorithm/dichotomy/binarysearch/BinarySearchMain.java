package program.algorithm.dichotomy.binarysearch;

import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchMain {
    public static void main(String[] args) {
        int n = 10;
        int max = 100;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                array[i] = 1;
                continue;
            }
            int tmp;
            do {
                tmp = random(max + 2 * i);
            } while (tmp <= array[i - 1]);
            array[i] = tmp;
        }
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < max; i++) {
            int x = random(max);
            int res = binarySearch_01(array, x);
            System.out.println("----------------");
            System.out.println("search value: " + x);
            if (res != -1) {
                System.out.println("array[" + res + "] = " + array[res]);
            }
        }
    }

    private static int binarySearch_01(int[] array, int x) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < x) {
                left = mid + 1;
            }
            if (array[mid] >= x) {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearch(int[] array, int x) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == x) {
                return mid;
            }
            if (array[mid] < x) {
                left = mid + 1;
            }
            if (array[mid] > x) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int random(int max) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(max);
    }
}

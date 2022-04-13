package org.example.searching;

public class SearchUtility {

    public static int linearSearch(int[] array, int targetValue) {

        int found = Integer.MIN_VALUE;

        for(int i : array) {
            if (i == targetValue) {
                found = targetValue;
                break;
            }
        }
        return found;
    }

    public static <T extends Comparable<T>> T linearSearch(T[] array, T targetValue) {

        T found = null;

        for(T value : array) {
            if (value.compareTo(targetValue) == 0) {
                found = targetValue;
                break;
            }
        }
        return found;
    }

    public static int binarySearchIterative(int[] array, int targetValue) {
        int min = 0;
        int max = array.length -1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                min = mid + 1;
            } else if (array[mid] > targetValue) {
                max = mid - 1;
            }
        }
        return -1;
    }
}

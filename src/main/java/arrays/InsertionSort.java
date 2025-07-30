package main.java.arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        insertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    /**
     *Start from the second element (index 1).
     * Compare it with elements to its left.
     * Shift larger elements one position to the right.
     * Insert the current element at the correct position.
     * Repeat until the entire array is sorted.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1], that are greater than current,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}

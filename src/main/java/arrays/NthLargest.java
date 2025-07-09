package main.java.arrays;

public class NthLargest {

    public static void main(String[] args) {
        int[] arr = {100, 2, 6, 8, 9, 2, 4, 7, 8, 10, 10, 100};
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j < max && j > max2)
                max2 = j;

            if (j > max) {
                max2 = max;
                max = j;
            }

        }
        System.out.println(max + "  " + max2);

        int mini = arr[0];
        int maxi = arr[0];
        for (int j : arr) {
            maxi = Math.max(j, maxi);
            mini = Math.min(j, mini);
        }
        System.out.println(maxi - mini);


        int[] binArray = {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        int count = 0, maxCount = 0;
        for (int i = 0; i < binArray.length; i++) {
            if (binArray[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        System.out.println("Max Count" + maxCount);
    }


}

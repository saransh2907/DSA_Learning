package main.java.arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr ={1, 2, 2, 4, 3, 1, 3};
        System.out.println(singleNumber(arr));
    }

    /**
     * Given an array of nums of n integers. Every integer in the array appears twice except one integer.
     * Find the number that appeared once in the array.
     * Examples:
     * Input : nums = [1, 2, 2, 4, 3, 1, 4]
     * Output : 3
     * Explanation : The integer 3 has appeared only once.
     */
    private static int singleNumber(int[] arr) {
        int num=arr[0];
        for(int i=1;i<arr.length;i++)
            num=num^arr[i];

        return num;
    }
}

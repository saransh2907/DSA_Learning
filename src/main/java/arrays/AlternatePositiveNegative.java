package main.java.arrays;

import java.util.Arrays;

public class AlternatePositiveNegative {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, -1, -3, -4};
//        positiveNegative(arr);
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    /**
     * Given an integer array nums of even length consisting of an equal number of positive and negative integers.
     * Return the answer array in such a way that the given conditions are met:
     * Every consecutive pair of integers have opposite signs.
     * For all integers with the same sign, the order in which they were present in nums is preserved.
     * The rearranged array begins with a positive integer.
     * Examples:
     * Input : nums = [2, 4, 5, -1, -3, -4]
     * Output : [2, -1, 4, -3, 5, -4]
     * Explanation: The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions
     */
    public static int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int pos=0;
        int neg=1;
        for(int i=0; i < nums.length; i++){
            if(nums[i]>0){
                arr[pos] = nums[i];
                pos+=2;
            } else{
                arr[neg] = nums[i];
                neg+=2;
            }
        }
        return arr;
    }
}

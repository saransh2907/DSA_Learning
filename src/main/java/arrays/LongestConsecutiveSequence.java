package main.java.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] arr ={100,4,200,1,3,2,8,7,6,9,10,201,202,203,204,205,206,207};
        int[] arr ={100,4,200,1,3,2};//,8,7,6,9,10,201,202,203,204,205,206,207};
        Arrays.sort(arr);
        int count = countConsecutiveSequence(arr);
        System.out.println(count);
    }

    /**
     * Given an array nums of n integers, return the length of the longest sequence of consecutive integers.
     * The integers in this sequence can appear in any order.
     * Examples:
     * Input: nums = [100, 4, 200, 1, 3, 2]
     * [1,2,3,4,100,200]
     * Output: 4
     * Explanation: The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4.
     * This sequence can be formed regardless of the initial order of the elements in the array.
     */
    private static int countConsecutiveSequence(int[] arr) {
        int count=1;
        int maxCount = 0;
        for(int i=1;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i-1])!=1) {
                count = 1;
                continue;
            }
            int j=i;
            while(j < arr.length && Math.abs(arr[j]-arr[j-1])==1){
                count++;
                j++;
            }
            maxCount = Math.max(maxCount,count);
            i=j-1;
        }
        return maxCount;
    }
}

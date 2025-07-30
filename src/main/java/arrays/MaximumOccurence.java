package main.java.arrays;

import java.util.Arrays;

public class MaximumOccurence {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 7, 7, 2, 7, 7, 7};
        System.out.println(votingAlgorithm(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(findNumber(arr));
    }

    /**
     * Given an integer array nums of size n, return the majority element of the array.
     * The majority element of an array is an element that appears more than n/2 times in the array.
     * The array is guaranteed to have a majority element.
     * Examples:
     * Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
     * Output: 7
     * Explanation: The number 7 appears 5 times in the 9 sized array
     */
    private static int findNumber(int[] arr) {
        return arr[arr.length/2];
        /*
        int maxNum=arr[0];
        int maxCount=1;
        int count =1;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==arr[i+1])
                count++;
            if(maxCount<=count){
                maxCount = count;
                maxNum = arr[i];
                count=0;
            }
        }
        return maxNum;
        */
    }

    private static int votingAlgorithm(int[] arr){
        int maxNum= arr[0];
        int count = 1;
        for(int i =1; i< arr.length; i++){
            if(count>0 && arr[i] == maxNum){
                count++;
            }else{
                count--;
                if(count==0){
                    maxNum = arr[i];
                    count = 1;
                }
            }
        }
        return maxNum;
    }
}

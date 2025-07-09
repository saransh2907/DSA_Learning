package main.java.arrays;

import java.util.Arrays;

public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 2, 0, 0, 1, 5, -2};
        int goal = 3;
        System.out.println(numSubarraysWithSum(nums,goal));
        System.out.println(numSubarraysWithSumCS(nums, goal));
    }

    /**
     * Given a binary array nums and an integer goal. Return the number of non-empty subarrays with a sum goal.
     * A subarray is a continuous part of the array.
     * Examples:
     * Input : nums = [1, 1, 0, 1, 0, 0, 1] , goal = 3
     * Output : 4
     * Explanation : The subarray with sum 3 are
     * [1, 1, 0, 1]
     * [1, 1, 0, 1, 0]
     * [1, 1, 0, 1, 0, 0]
     * [1, 0, 1, 0, 0, 1].
     */
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            sum = 0;
            while (j < nums.length) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                    System.out.println("["+i +" " + j +"] s="+ sum + " c=" + count);
                }
                j++;
            }
        }
        return count;
    }

    /**
     * Cumulative sum approach
     */
    private static int numSubarraysWithSumCS(int[] nums, int goal) {
        int[] cs = new int[nums.length];
        cs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cs[i] = cs[i - 1] + nums[i];
        }
//        System.out.println(Arrays.toString(cs));
        int count =0;
        int ind = 0;
        while(cs[ind] <= goal){
            if(cs[ind] == goal)
                count++;
            ind++;
        }
        System.out.println("==>"+count);
        while(ind < nums.length){
            int target =  cs[ind] - goal;
            for(int i =ind; i >= 0; i--){
                if(cs[i] == target){
                    count++;
                }
            }
            ind++;
        }
        return count;
    }
}

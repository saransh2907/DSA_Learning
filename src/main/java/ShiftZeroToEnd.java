package main.java;

import java.util.Arrays;

public class ShiftZeroToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,4,0,5,2};
        shiftElementToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void shiftElementToEnd(int[] nums) {
        int l= nums.length;
        int i =0;
        for(int j=1; j<l ;j++) {
            if( nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
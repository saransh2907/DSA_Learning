package main.java.google;


import java.util.Arrays;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
 * sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class SmallestSubsum {

    public static void main(String[] args) {
        int target = 15;
//        int[] nums = {2,3,1,2,4,3};
//        int[] nums = {1,1,1,1,1,1,1,1};
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
//        int[] nums = {1,4,4};

//        int x = findSubarray(nums, target);
//        System.out.println(x);
        int x2 = findSubarray2(nums, target);
        System.out.println(x2);
    }

    private static int findSubarray(int[] nums, int target) {
        int sum = 0;
        int left = 0;
        int minLength = nums.length;
        for(int right =0 ; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return minLength;
    }
    private static int findSubarray2(int[] nums, int target) {
        int[] ps = new int[nums.length+1];
        ps[0] = 0;
        for(int i =1 ; i < ps.length; i++){
            ps[i] += nums[i-1] + ps[i-1];
        }
        System.out.println(Arrays.toString(ps));
        if(target > ps[nums.length]){
            return 0;
        }
        int minLen = nums.length;
        for(int i =0; i < ps.length; i++){
            if(ps[ps.length-1] - ps[i] >= target) {
                int x = binarySearch(i + 1, ps.length - 1, target + ps[i], ps);
                minLen = Math.min(x - i, minLen);
//                System.out.println("i=" + i + " x=" + x + "Min=" + minLen);
            }
        }
        return minLen;
    }

    public static int binarySearch(int l, int r, int target, int[] arr){
        while(l <= r){
            int mid = (l+ r)/2;
            if(arr[mid] >= target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}

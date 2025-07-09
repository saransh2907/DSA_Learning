package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, -7, 6, -3, 45};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 41;
        int[] ind = getTargetSum(arr, target);
        System.out.println(Arrays.toString(ind));
        int[] ind2 = getNearestTargetSum(arr, target);
        System.out.println(Arrays.toString(ind2));
    }

    /**
     * Given an array and a target sum get the indices of the pair that adds up to the target value
     * @param arr
     * @param target
     * @return
     */
    private static int[] getTargetSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
//        int[] newArr = new int[2];
        for(int i=0; i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
//                newArr[1]=i;
//                newArr[0]=map.get(target-arr[i]);
                return new int[] {i,map.get(target-arr[i])};
            }
            else{
                map.put(arr[i],i);
            }
        }
//        return newArr;
        return null;
    }

    /**
     * Given an array and a target sum get the indices of the pair that adds to closest value of the target value
     * @param arr
     * @param target
     * @return
     */
    private static int[] getNearestTargetSum(int[] arr, int target) {

        int left =0;
        int right = arr.length-1;
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(left < right){
            int sum = arr[left] + arr[right];
            if(minDiff > Math.abs(sum-target)){
                minDiff = Math.abs(sum-target);
                ans[0] = left;
                ans[1] = right;
            }
            if(sum > target){
                right--;
            }else if( sum < target){
                left ++;
            }else{
                return new int[] {left,right};
            }
        }


        return ans;
    }
}
package main.java;

public class Kadane {

    public static void main(String[] args) {
//        int[] arr = {2,3,5,-2,7, -4};
        int[] arr = {5,-10,77, -4};

        int maxSum = getMaxSumInSubarray(arr);
        System.out.println(maxSum);
    }
    /**
     * Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * Input: nums = [2, 3, 5, -2, 7, -4]
     * Output: 15
     * Explanation: The subarray from index 0 to index 4 has the largest sum = 15
     */
    public static int getMaxSumInSubarray(int[] arr){
        int sum;
        int first=0, last=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
                sum=0;
                for(int j=i;j<arr.length;j++){
                    sum+=arr[j];
//                    maxSum= Math.max(sum,maxSum);
                    if(sum > maxSum) {
                        System.out.println("updating i" + i +" j"+ j + " sum"+sum);
                        first = i;
                        last = j;
                        maxSum = sum;
                    }
//                    System.out.println(maxSum);
                    if(sum<0){
                        break;
                    }
                }
        }
        System.out.print("[");
        for(int i=first;i<=last;i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
        return maxSum;
    }
}

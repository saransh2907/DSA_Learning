package main.java;

public class LargestConsecutiveSum {

    public static void main(String[] args) {
        int[] arr = {5,6,-7,12,18,-5,-6};
        int k = 3;
        int ans = getLargestConsecutiveSum(arr,k);
        System.out.println(ans);
    }

    private static int getLargestConsecutiveSum(int[] arr, int k) {
        int sum =0;
        for(int i=0;i<k;i++){
            sum+= arr[i];
        }
        int maxSum=sum;
        for(int i=k;i<arr.length-1;i++){
            sum=sum-arr[i-k]+arr[i];
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;
    }

}

package main.java;

import java.util.Arrays;

public class BiggestPair {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,8,9,9,0,0,5,3,2,2,2,46,6,7};
//        int array[] = {-1, -1, -5, -10, -8 };
//        int array[] = {5};
        int largestPair = getLargestPair(array);
        int subPair = getLargestSubsequence(array);
        System.out.println(largestPair);
        System.out.println(subPair);
    }

    /**
     * find the largest pair i.e. the element that appear adjacent and have  sum value
     * @param array
     * @return
     */
    private static int getLargestPair(int[] array) {
        if(array.length < 2){
            return -1;
        }
        int sum=array[0]+array[1];
        for(int i = 0; i < array.length-1;i++){
            sum = Math.max(sum,array[i]+array[i+1]);
        }
        return sum;

    }

    /**
     * find the largest pair i.e. the element that may appear anywhere;
     * @param array
     * @return
     */
    private static int getLargestSubsequence(int[] array) {
        if(array.length < 2){
            return -1;
        }
        /** Approach 1
        int sum=array[0]+array[1];
        for(int i = 0; i < array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                sum = Math.max(sum,array[i]+array[j]);
            }
        }
        return sum;
         */

        /** Approach 2
         Arrays.sort(array);
         return (array[array.length-1]+array[array.length-2]);
         */

        /** Approach 3 */
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int j : array) {
            if (j < max && j > max2)
                max2 = j;
            if (j > max) {
                max2 = max;
                max = j;
            }
        }
        return max + max2;
    }
}

package main.java;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] arr1 = {2,4,6,8,10};
        int[] arr2 = {1,3,5,7,9,10};
        int[] ans = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Given 2 sorted arrays arr1 and arr2 return an array which is merged but sorting order is maintained
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int [] arr=new int [arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length &&   j< arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }
            else {
                arr[k]=arr2[j];
                j++;
            }
            k++;
        }
        if(i==arr1.length){
            for(;j<arr2.length;j++,k++){
                arr[k]=arr2[j];
            }
        }
        if (j==arr2.length) {
            for(;i<arr1.length;i++,k++){
                arr[k]=arr1[i];
            }
        }
        return arr;
    }

}

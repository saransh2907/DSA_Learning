package main.java.google;


import java.util.Arrays;

/**
 * Problem Statement: Given an integer array sorted in non-decreasing order,
 * remove the duplicates in place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 *
 * Examples
 * Input: arr[]=[1,1,2,2,2,3,3]
 * Output: [1,2,3,,,,]
 * Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 * Input: arr[]=[1,1,1,2,2,3,3,3,3,4,4]
 * Output: [1,2,3,4,,,,,,,_]
 * Explanation: Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int arr[]={1,1,2,2,2,3,3};
        int ans = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    private static int removeDuplicates(int[] arr) {
        if(arr.length ==0){
            return 0;
        }
        int prev = arr[0];
        int count = 1;
        for(int i =1; i < arr.length; i++){
            if( arr[i] != prev){
                prev = arr[i];
                arr[count] = arr[i];
                count++;
            }
        }
        return count;
    }

    public int removeDuplicates2pointer(int[] arr) {
        if(arr.length ==0){
            return 0;
        }
        int i = 0;
        for(int j = i+1; j < arr.length; j++){
            if( arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

}

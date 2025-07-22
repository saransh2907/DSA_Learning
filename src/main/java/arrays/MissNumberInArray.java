package main.java.arrays;

import java.util.Arrays;

public class MissNumberInArray {
    public static void main(String[] args) {
//    int[] nums = {0, 2, 3, 1, 4};
        int[] nums = {0, 1, 2, 4, 5, 6};
        Arrays.sort(nums);
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int l= nums.length;
        for(int i = 0;i<=l;i++){
            if(searchELement(nums,i,nums.length)<0){
                return i;
            }
        }
        return -1;
    }
    public static int searchELement(int[] array, int searchElement, int length){
        int start = 0;
        int end = length-1;
        int mid =(start+end)/2;
        while(start<=end){
            mid = (start+end)/2;
            if(searchElement==array[mid]){
                while(mid >0 && array[mid -1] == searchElement){
                    mid--;
                }
                return mid;
            }
            else if(searchElement<array[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}

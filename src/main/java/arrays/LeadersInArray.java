package main.java.arrays;

import java.util.Arrays;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr={10, 22, 12, 3, 0, 6};
//        System.out.println(Arrays.toString(findLeaders(arr)));
        findLeaders(arr);
    }

    private static void findLeaders(int[] arr) {
        int[] cumulativeMax =new int[arr.length];
        int currentMax=0;
        for(int i= arr.length-1;i>=0;i--){
            currentMax = Math.max(arr[i],currentMax);
            cumulativeMax[i]=currentMax;
        }
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]==cumulativeMax[i])
                System.out.println(arr[i]);
        }

    }
}

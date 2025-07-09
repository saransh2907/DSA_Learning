package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,6};
        int[] array = {1,2,2,3,3,3,4,4,5,6};
//        Arrays.sort(array);
        int element= 1;
        int index = binarySearch(array,element, array.length);
        System.out.println(index);
        System.out.println("Good pair" + numberOfGoodPair(array,6));
    }
    /**
     * Find the element in the sorted integer array. If found return the index  of thr first occuraance else return -1
     */
    private static int binarySearch(int[] array,int searchElement, int length){
        int start = 0;
        int end = length-1;
        int mid =(start+end)/2;
        while(start<=end){
            mid = (start+end)/2;
            System.out.println(start + "" + mid + "" + end);
            if(searchElement==array[mid]){
                while(mid >0 && array[mid -1] == searchElement){
                    mid--;
                    System.out.println("-->"+start + "" + mid + "" + end);
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

    /**
     * find good pair in a sorted array
     * a pair is good if the sum of the elements matches the target value
     * return the number of good pair
     */
    private static int numberOfGoodPair(int[] array, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+ 1);
            }
            else{
                map.put(array[i],1);
            }
        }

        for(int i=0;i<array.length && array[i]< target/2;i++) {
            if (map.containsKey(target - array[i])) {
                count += map.get(target - array[i]);
            }
        }
        if(map.containsKey(target/2)){
            int c = map.get(target/2);
            count+= c * (c-1) * 0.5;
        }
        return count;
    }
}

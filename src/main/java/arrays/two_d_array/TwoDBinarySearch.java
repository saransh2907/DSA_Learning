package main.java.arrays.two_d_array;


public class TwoDBinarySearch {
    public static void main(String[] args) {
        int[] arr= {1,2,5,7,11,13};
        int target=8;
        System.out.println(binSearch(arr,target));

        int[][] arr2D = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int ind = binSearch2D(arr2D,target);
        System.out.println("["+ind + "]["+binSearch(arr2D[ind],target) + "]");
    }
    public static int binSearch(int[] arr,int target){
        int start= 0;
        int end =arr.length;
        while(start<end){
            int mid=(start+end)/2;
            /**
             * If our target is greater than mid element then we set start to mid but not go mid +1 because
             * our element could be present in range of mid and (mid +1) because we are interested in just smaller index
             * so cannot skip mid to mid+1 interval
             * we are interested in just smaller element so if element is greater we move toward left
             */
            if(target>arr[mid])
                start=mid;
            else if (target<arr[mid])
                end=mid-1;
            else
                return mid;
        }
        return start;
    }

    public static int binSearch2D(int[][] arr,int target){
        int start= 0;
        int end =arr.length;
        while(start<end){
            int mid=(start+end)/2;
            if(target>arr[mid][0])
                start=mid;
            else if (target<arr[mid][0])
                end=mid-1;
            else
                return mid;
        }
        return start;
    }


}

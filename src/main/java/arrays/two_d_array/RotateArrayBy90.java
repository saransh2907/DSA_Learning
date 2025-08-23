package main.java.arrays.two_d_array;

import java.util.Arrays;

public class RotateArrayBy90 {
    public static void main(String[] args) {
//        int[][] arr = {{0, 1, 1, 2}, {2, 0, 3, 1}, {4, 5, 0, 5}, {5, 6, 7, 0}};
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("Rotated by 90 ===>");
        rotateFunc(arr);
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
    }

    private static void rotateFunc(int[][] arr) {
        int m = arr.length;
        int temp;
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m/2;j++){
                temp = arr[i][j];
                arr[i][j] = arr[i][m-j-1];
                arr[i][m-j-1]=temp;
            }
        }
    }

}

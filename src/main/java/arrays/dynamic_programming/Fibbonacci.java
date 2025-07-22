package main.java.arrays.dynamic_programming;

import java.util.Arrays;

public class Fibbonacci {

    public static void main(String[] args) {
        int n = 6;
        int y = fibbonacci(n);
        System.out.println(y);


        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        int x = fibbonacciMem(n, arr);
        System.out.println(x);

        int[] arr2 = new int[n+1];
        Arrays.fill(arr, -1);
        int z = fibbonacciTabulation(n, arr2);
        System.out.println(z);

        int w = fibbonacciOptimized(n);
        System.out.println(w);

    }

    private static int fibbonacci(int n) {
//        System.out.println("You are called");
        if (n==1)
            return 0;
        else if(n==2)
            return 1;
        else
            return fibbonacci(n-1)+fibbonacci(n-2);
    }

    private static int fibbonacciMem(int n, int[] arr) {
//        System.out.println("I am called" + n);
        if (n==1)
            return 0;
        else if(n==2)
            return 1;
        else{
            if(arr[n] == -1){
//                int x = fibbonacciMem(n-1,arr) + fibbonacciMem(n-2, arr);
//                arr[n] = x;
//                System.out.println(Arrays.toString(arr));
//                return  x;
                return arr[n] = fibbonacciMem(n-1,arr) + fibbonacciMem(n-2, arr);
            }else{
                return arr[n];
            }
        }
    }

    private static int fibbonacciTabulation(int n, int[] arr){
        arr[0] = -1;
        arr[1] = 0;
        arr[2] = 1;
        for(int i = 3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    private static int fibbonacciOptimized(int n){
        if(n < 3){
            return n-1;
        }
        int x = 0;
        int y = 1;
        int z = y + x;
        for(int i = 3; i<=n; i++){
            z = y + x;
            x = y;
            y = z;

        }
        return z;
    }


}

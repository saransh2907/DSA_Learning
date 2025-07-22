package main.java.arrays.dynamic_programming;

import java.util.Arrays;

public class FrogJump {

    static int memo =0;
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
//        int[] arr = {7, 5, 1, 2, 6,6,6,6,6};
/*-------Recursive */
//         int energy = calculateMinEnergy(arr,0);
//        System.out.println(energy);
/*--------Memoization --------------*/
          int [] minE = new int[arr.length];
          Arrays.fill(minE,-1);
          int energy = calculateMinEnergyMemo(arr,0,minE);
          System.out.println(Arrays.toString(minE));
          System.out.println(energy);
/*--------Tabulation */
        int energy1 = calculateMinEnergyTabulation(arr);
        System.out.println(energy1);
/*--------Optimized----------------*/
        int energy2 = calculateMinEnergyOptimized(arr);
        System.out.println(energy2);
    }

    /**
     * A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
     * To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists. Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
     * Examples:
     * Input: heights = [2, 1, 3, 5, 4]
     * Output: 2
     * Explanation: One possible route can be,
     * 0th step -> 2nd Step = abs(2 - 3) = 1
     * 2nd step -> 4th step = abs(3 - 4) = 1
     * Total = 1 + 1 = 2.
     */
    private static int calculateMinEnergy(int[] arr,int i) {
        System.out.println("Call " + memo++);
        if(i>=arr.length-1)
            return 0;
        if(i==arr.length-2)
            return Math.abs(arr[i+1]-arr[i]);

        int energy1 = Math.abs(arr[i+1]-arr[i])+ calculateMinEnergy(arr,i+1);
        int energy2 = Math.abs(arr[i+2]-arr[i])+ calculateMinEnergy(arr,i+2);
        return Math.min(energy1,energy2);

    }
    private static int calculateMinEnergyMemo(int[] arr,int i, int[] minE) {
        System.out.println("Call " + memo++);
        if(i>=arr.length-1)
            return 0;
        if(i==arr.length-2)
            return Math.abs(arr[i+1]-arr[i]);
        if(minE[i]==-1) {
            int energy1 = Math.abs(arr[i+1]-arr[i]) + calculateMinEnergyMemo(arr,i+1,minE);
            int energy2 = Math.abs(arr[i+2]-arr[i]) + calculateMinEnergyMemo(arr,i+2,minE);
            return minE[i]= Math.min(energy1,energy2);
        } else
            return minE[i];

    }
    private static int calculateMinEnergyTabulation(int[] arr) {
        int[] minE = new int[arr.length];
        minE[0]=0;
        minE[1]= Math.abs(arr[1]-arr[0]);
        for(int i = 2;i < arr.length; i++){
            int energy1 = Math.abs(arr[i]-arr[i-1]) + minE[i-1];
            int energy2 = Math.abs(arr[i]-arr[i-2]) + minE[i-2];
            minE[i] = Math.min(energy1,energy2);
        }
        System.out.println(Arrays.toString(minE));
        return minE[arr.length -1];
    }

    private static int calculateMinEnergyOptimized(int[] arr) {
        int e1 = 0;
        int e2 = Math.abs(arr[1]-arr[0]);
        for(int i = 2;i < arr.length; i++){
            int energy1 = Math.abs(arr[i]-arr[i-1]) + e2;
            int energy2 = Math.abs(arr[i]-arr[i-2]) + e1;
            e1 = e2;
            e2 = Math.min(energy1,energy2);
        }
        return e2;
    }
}

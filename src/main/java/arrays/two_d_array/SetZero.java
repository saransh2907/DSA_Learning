package main.java.arrays.two_d_array;

import java.util.Arrays;

public class SetZero {

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        int[][] out = setZeroOpt(arr);
        for (int[] a : out) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("*************************");
//        setZeroOpt(arr);
    }

    private static int[][] setZero(int[][] arr) {
        int[][] out = new int[arr.length][arr[0].length];
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currEle = arr[i][j];
                if (currEle == 0) {
                    out[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (arr[i][k] == 0) {
                        currEle = 0;
                        break;
                    }
                }
                if (currEle == 0) {
                    out[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    if (arr[k][j] == 0) {
                        currEle = 0;
                        break;
                    }
                }
                out[i][j] = currEle;
            }
        }

        return out;
    }

    private static int[][] setZeroOpt(int[][] arr) {
        int[][] out = new int[arr.length][arr[0].length];
        int m = arr.length;
        int n = arr[0].length;
        int[] rowProd = new int[m];
        int[] colProd = new int[n];

        for (int i = 0; i < m; i++) {
            rowProd[i]=1;
            for (int j = 0; j < n; j++) {
                rowProd[i] *= arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            colProd[i]=1;
            for (int j = 0; j < m; j++) {
                colProd[i] *= arr[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowProd[i] == 0 || colProd[j] == 0)
                    out[i][j] = 0;
                else
                    out[i][j] = arr[i][j];
            }
        }
        return out;
    }
}

package main.java.arrays.two_d_array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalofMatrix {
    public static void main(String[] args) {
        int[][] arr= {  { 1,  2,  3,  4 , 100},
                        { 5,  6,  7,  8 , 101},
                        { 9, 10, 11, 12 , 102},
                        {13, 14, 15, 16 , 103},
                        {17, 18, 19, 20 , 104},
                        {21, 22, 23, 24 , 105},};

//        int[][] arr = {{10, 11}};
//        int[] ans = spiralPrint(arr);
//        System.out.println("\n"+Arrays.toString(ans));
        List<Integer> ans = spiralOrder(arr);
        System.out.println();
        System.out.println(ans);
    }

    private static int[] spiralPrint(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m*n];
        int x=0;
//        while(){
        for(int counter=0;counter<=Math.min(m/2,n/2);counter++){
            int i=counter;
            int j;
            for(j=counter;j<=n-1-counter;j++) {
                System.out.print(matrix[i][j] + ", ");
                ans[x++] = matrix[i][j];
            }
            j=n-1-counter;
            for(i=counter+1;i<=m-1-counter;i++) {
                System.out.print(matrix[i][j] + ", ");
                ans[x++] = matrix[i][j];
            }
            i=m-1-counter;
            for(j=n-2-counter;j>=counter && i > (m/2) ;j--) {
                System.out.print(matrix[i][j] + ", ");
                ans[x++] = matrix[i][j];
            }
            j=counter;
            for(i=m-2-counter;i>=counter+1;i--) {
                System.out.print(matrix[i][j] + ", ");
                ans[x++] = matrix[i][j];
            }
        }
        List<Integer> op = new ArrayList<>();
        for(int num: ans){
            op.add(num);
        }
        return ans;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> op = new ArrayList<>();
//        while(){
        int l = 0;
        int r = n-1;
        int t = 0;
        int b = m-1;
        while(l<r && t<b){
            int i=t;
            int j;
            for(j=l;j<=r;j++) {
                System.out.print(matrix[i][j] + ", ");
                op.add(matrix[i][j]);
            }
            j--;
            t++;
            for(i=t;i<=b;i++) {
                System.out.print(matrix[i][j] + ", ");
                op.add(matrix[i][j]);
            }
            i--;
            r--;
            for(j=r;j>=l ;j--) {
                System.out.print(matrix[i][j] + ", ");
                op.add(matrix[i][j]);
            }
            j++;
            b--;
            for(i=b;i>=t ;i--) {
                System.out.print(matrix[i][j] + ", ");
                op.add(matrix[i][j]);
            }
            l++;
        }
        return op;
    }
}

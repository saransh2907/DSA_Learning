package main.java.graphs;

import  java.util.*;

public class Matrix_0_1 {

    public static void main(String[] args) {
        int[][] input= new int[][] {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        printArr(input);
        System.out.println("________________*************__________________");
        printArr(updateMatrix(input));
    }
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        int[][] out = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0; i < n; i ++){
            for(int j =0; j < m; j++){
                if(mat[i][j] == 0 ){
                    out[i][j] = 0;
                    q.add(new int[]{i, j});
                }else
                    out[i][j] = -1;
            }
        }

        while ( !q.isEmpty() ){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && out[nx][ny] == -1) {
                    out[nx][ny] = out[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return out;
    }

    public static void printArr(int[][] arr){
        for(int[] a : arr){
            System.out.println("\t"+Arrays.toString(a));
        }
        System.out.println();
    }
}

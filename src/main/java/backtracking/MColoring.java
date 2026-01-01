package main.java.backtracking;

import java.util.Arrays;

/**
 * You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][],
 * along with an integer m. Your task is to determine whether it is possible to color the graph using at most
 * m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored
 * with at most m colors, otherwise return false.
 * Note: The graph is indexed with 0-based indexing.
 * Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
 * Output: true
 * Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices
 * can be colored as follows:
 */
public class MColoring {
    static boolean[][] graph;
    static int N;
    static int[] color;

    public static void main(String[] args) {
        int v = 4;
        int edges[][] = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
        int m = 3;

        boolean ans = graphColoring(v,edges,m);
        System.out.println(ans?"Can color" : "Cannot color");

        v = 3;
        edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        m = 2;
        ans = graphColoring(v,edges,m);
        System.out.println(ans?"Can color" : "Cannot color");
    }

    public static boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        N = v;
        graph = new boolean[v][v];

        for(int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        color = new int[v];
        Arrays.fill(color, -1);
        color[0] = 0;
        return canColor(0, m);

    }

    public static boolean canColor(int node, int m){
        if(node == N)
            return true;
        for(int i = 0; i < m; i++){
            boolean check = isValid(node, i);
            if(check){
                color[node] = i;
                if(canColor(node + 1, m))
                    return true;
                color[node] = -1;
            }
        }
        return false;
    }

    public static boolean isValid(int node, int i){
        for(int k= 0; k < node; k++){
            if( graph[node][k] && color[k] == i)
                return false;
        }
        return true;
    }
}
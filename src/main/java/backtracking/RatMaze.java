package main.java.backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RatMaze {


    static int maze[][];
    static int n;
    static boolean[][] visited;
    static List<String> ans;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static char[] dir = new char[]{'L', 'R', 'U', 'D'};

    static String[][] ansList;

    public static void main(String[] args) {
        int[][] mazeEx = new int[][]{{1, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1,
                1}};


        maze = mazeEx;
        n = maze.length;

        ans = new ArrayList<>();
        visited = new boolean[n][n];

        long start = System.currentTimeMillis();
        if(mazeEx[0][0] == 1 && mazeEx[n-1][n-1] == 1){
            race(0, 0, new StringBuilder());
        }
        long end = System.currentTimeMillis();
        System.out.println(ans.stream().collect(Collectors.joining(", ")) + "\n " + (end - start));

    }

    public static void race(int i, int j, StringBuilder path) {
        if (i == n - 1 && j == n - 1) {
            ans.add(path.toString());
            return;
        }
        visited[i][j] = true;

        for (int x = 0; x < 4; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && maze[nx][ny] == 1) {
                path.append(dir[x]);
                race(nx, ny, path);
                path.deleteCharAt(path.length() - 1);
            }
        }
        visited[i][j] = false;
    }
}

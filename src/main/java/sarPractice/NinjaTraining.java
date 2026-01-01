package main.java.sarPractice;

import main.java.arrays.Utils;

public class NinjaTraining {
    /**
     * A ninja has planned a n-day training schedule. Each day he has to perform one of three activities -
     * running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and
     * the ninja earns a specific number of merit points, based on the activity and the given day.
     * Given a n x 3-sized matrix, where matrix{i}{0}, matrix{i}{1}, and matrix{i}{2}, represent the merit points
     * associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum
     * possible merit points that the ninja can earn.
     *
     * Input: matrix = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}}
     * Output: 210
     * Explanation:
     * Day 1: fighting practice = 70
     * Day 2: stealth training = 50
     * Day 3: fighting practice = 90
     * Total = 70 + 50 + 90 = 210
     * This gives the optimal points.
     *
     * Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
     * Output: 290
     */
    static int calls;

    public static void main(String[] args) {
//        int[][] matrix = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        int[][] matrix = {{70, 40, 10}, {180, 20, 5},{200, 60, 30},{1,1,1}};
        int score = ninjaTraining(matrix);
        System.out.println("Max training points acquired:"+score);
    }

    public static int ninjaTraining(int[][] matrix) {
        /*-----Recursion Method-----*/
        System.out.println("\n-----Recursion Method-----");
        calls =0;
        System.out.println("Ans:"+getMaxScoreRecursion(matrix,matrix.length-1,3));
        System.out.println("Recursive Function call "+ calls + " times");
        /*-----Memoization Method-----*/
        System.out.println("\n-----Memoization Method-----");
        calls =0;
        int[][] dp = new int[matrix.length][4];
        int score = getMaxScoreMemoization(matrix, matrix.length-1,3,dp);
        System.out.println("Ans:"+ score);
        System.out.println("Memoization Function call "+ calls + " times");
        Utils.print2DArray(dp);
        /*-----Tabulation Method-----*/
        System.out.println("\n-----Tabulation Method-----");
        System.out.println("Ans:"+ getMaxScoreTabulation(matrix));
        return score;
    }
     public static int getMaxScoreRecursion(int[][] matrix, int index, int prevInd){
        calls++;
        if(index < 0)
            return 0;
//        System.out.println("Recursive Function call "+ calls + " with index:"+ index + " and prevInd:"+ prevInd);
        int score=0;
        for(int i =0; i <3; i++){
            if(i == prevInd)
                continue;
            int currScore = matrix[index][i] + getMaxScoreRecursion(matrix,index-1, i);
            score = Math.max(score,currScore);
        }
        return score;
    }

    public static int getMaxScoreMemoization(int[][] matrix, int index, int prevInd, int[][] dp) {
//        System.out.println("Memoization Function call "+ calls + " with index:"+ index + " and prevInd:"+ prevInd);
        calls++;
        if(index < 0)
            return 0;
        if( dp[index][prevInd] != 0)
            return dp[index][prevInd];

        int score=0;
        for(int i =0; i <3; i++){
            if(i == prevInd)
                continue;
            int currScore = matrix[index][i] + getMaxScoreMemoization(matrix,index-1, i, dp);
            score = Math.max(score,currScore);
        }
        return dp[index][prevInd]=score;
    }
    public static int getMaxScoreTabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4]; // prevInd goes from 0 to 3 (3 = "no previous index")
        // Base case: first row (index = 0), no previous column
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    dp[0][i] = Math.max(dp[0][i], matrix[0][j]);
                }
            }
        }
        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < 4; prev++) {
                dp[i][prev] = 0; // initialize current dp[i][prev]
                for (int curr = 0; curr < 3; curr++) {
                    if (curr != prev) {
                        dp[i][prev] = Math.max(dp[i][prev], matrix[i][curr] + dp[i - 1][curr]);
                    }
                }
            }
        }

        Utils.print2DArray(dp);

        // Final answer will be dp[n-1][3], meaning "no previous column constraint at last row"
        return dp[n - 1][3];
    }






}

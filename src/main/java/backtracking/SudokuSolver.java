package main.java.backtracking;

import java.util.Arrays;

public class SudokuSolver {

    static char[][] sudoku;
    static int n;

    public static void main(String[] args) {
        char[][] board = new char[][]{
                 {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sudoku = board;
        sudoku();
        printArr(sudoku);
    }

    public static boolean sudoku(){
        for (int row = 0; row< 9; row++) {
            for (int col = 0; col< 9; col++) {
                if ('.' == sudoku[row][col]){
                    for (char num = '1'; num <= '9' ; num++) {
                        boolean check = isValid(row, col, num);
                        if (check) {
                            sudoku[row][col] = num;
//                            printArr(sudoku);
                            if(sudoku()) return true;
                            sudoku[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int row, int col, char num) {
        // check element in row and column
        for (int x = 0; x < 9; x++) {
            if (num==sudoku[x][col])
                return false;
            if (num==sudoku[row][x]) {
                return false;
            }
        }
        int x1 = (row / 3) * 3;
        int y1 = (col / 3) * 3;
        for (int i = x1; i < x1 + 3; i++) {
            for (int j = y1; j < y1 + 3; j++) {
                if (num == (sudoku[i][j]))
                    return false;
            }
        }
        /** Alternate logic
             *  int start = row - (row%3);
                 int end = col - (col %3);
                 for(int i = 0; i < 3; i++){
                    for(int j = 0; i < 3; j++){
                        if(String.valueOf(num).equals(sudoku[start+i][end+j] ))
                            return false;
                    }
                 }
             */
        return true;
    }

    public static void printArr(char[][] arr){
        for(char[] a : arr){
            System.out.println("\t"+ Arrays.toString(a));
        }
        System.out.println();
    }
}

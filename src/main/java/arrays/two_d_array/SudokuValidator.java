package main.java.arrays.two_d_array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuValidator {
    public static void main(String[] args) {
        char[][] board = {  {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {

        boolean isValid = checkValidChar(board);
        System.out.println("ValidChar");
        if(!isValid)
            return false;
        isValid = checkMatrix(board);
        System.out.println("ValidMatrix");
        if(!isValid)
            return false;
        isValid = checkRowsCols(board);
        System.out.println("ValidRowCols");
        return isValid;

    }

    private static boolean checkValidChar(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch!='.' && ( ch<'1' || ch>'9'))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkRowsCols(char[][] board) {
        for (int i=0;i<9;i++){
            int[] rowFreq = new int[9];
            int[] colFreq = new int[9];
            for(int j=0;j<9;j++){
                char ch1=board[i][j];
                char ch2=board[j][i];
                if (ch1 >= '1' && ch1 <= '9') {
                    int val = ch1 - '1';
                    if(rowFreq[val]==1){
                        return false;
                    }
                    else{
                        rowFreq[val]=1;
                    }
                }
                if (ch2 >= '1' && ch2 <= '9') {
                    int val = ch2 - '1';
                    if(colFreq[val]==1){
                        return false;
                    }
                    else{
                        colFreq[val]=1;
                    }
                }
            }
        }
        return true;
    }


    public static boolean checkMatrix(char[][] board) {
        for (int m = 0; m < 9; m++) {
            int[] freq = new int[9];
            for (int k1 = 0; k1 < 3; k1++) {
                int i = ((m / 3) * 3) + k1;
                for (int k2 = 0; k2 < 3; k2++) {
                    int j = ((m % 3) * 3 + k2);
                    char ch = board[i][j];
                    if (ch >= '1' && ch <= '9') {
                        int val = ch - '1';
                        if(freq[val]==1)
                            return false;
                        else
                            freq[val]=1;
                    }
                }
            }
        }
        return true;
    }
}


package main.java.arrays;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] coins = {2,5};
        int amount = 11;
        int coinsRequired = minimumCoinsRequired(coins,amount);
        System.out.println(coinsRequired);
    }

    /**
     *  11 , [2,5] => 2,2,2,5
     *  3 , [5] => -1
     */
    private static int minimumCoinsRequired(int[] coins, int amount) {
        int count=0;
        int j=coins.length-1;
        Arrays.sort(coins);
        while(amount>0 && j>=0){
            count += amount/coins[j];
            amount=amount%coins[j];
            j--;
        }
        return count;
    }
}

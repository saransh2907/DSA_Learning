package main.java.arrays.knapsack;

import java.util.Arrays;

public class FractionalKnapsackCoins {

    public static void main(String[] args) {
//        int[] coins = {1,3,4};
        int[] coins = {2,5};
        int amount = 11;
        int coinsRequired = minimumCoinsRequired(coins,amount);
        System.out.println(coinsRequired);
        coinsRequired = minCoinsUsed(coins,amount,0);
        System.out.println(coinsRequired);
    }

    /**
     *  11 , [2,5] => 2,2,2,5
     *  3 , [5] => -1
     */
    /**
     * greedy approach
     */
    private static int minimumCoinsRequired(int[] coins, int amount) {
        int count=0;
        int j=coins.length-1;
        Arrays.sort(coins);
        while(amount>0 && j>=0){
            int coin = coins[j];
            if(amount<coin) {
                j--;
                continue;
            }
            count += amount/coins[j];
            amount=amount%coins[j];
            j--;
        }
        return amount==0?count:-1;
    }
    /**
     * Recursive approach
     */
    public static int minCoinsUsed(int[] coins, int amount, int index){
        if( amount ==0){
            return 0;
        }
        if(amount < 0 || index==coins.length) {
            return Integer.MAX_VALUE -1;
        }
        int countPicked = Integer.MAX_VALUE;
        if(amount>=coins[index]) {
            countPicked = 1+ minCoinsUsed(coins,amount - coins[index], index);
        }
        int countNotPicked = minCoinsUsed(coins,amount,index+1);
        return Math.min(countPicked,countNotPicked);
    }
}

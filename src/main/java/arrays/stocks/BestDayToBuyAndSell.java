package main.java.arrays.stocks;

public class BestDayToBuyAndSell {

    public static void main(String[] args) {

//        int[] arr = {10, 7, 5, 8, 11, 9};
        int[] arr = {5,4,7,1,6, 1};
//        int profit = getMaxProfit(arr);
        int profit2 = getMaxProfitMultiple(arr,0, 1);
        System.out.println(profit2);
    }

    /**
     * Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the
     * maximum profit achievable by buying and selling the stock at most once.
     */
    private static int getMaxProfit(int[] arr){
        int min = arr[0];
        int maxProfit = 0;
        for(int i =1; i < arr.length; i++){
            int profit = arr[i] - min;
            maxProfit  = Math.max(maxProfit, profit);
            min = Math.min(min, arr[i]);
        }

        return maxProfit;
    }

    private static int getMaxProfitMultiple(int[] arr, int index, int buy){
        int profit = 0;
        if(index==arr.length)
           return 0;
       else{
           if(buy==0){
                int sell = arr[index] + getMaxProfitMultiple(arr,index+1,1);
                int notSell = getMaxProfitMultiple(arr, index+1, buy);
                profit += Math.max(sell,notSell);
           }else{
               int buyS = -arr[index] + getMaxProfitMultiple(arr,index+1,0);
               int notB= getMaxProfitMultiple(arr, index+1, buy);
               profit+= Math.max(buyS,notB);
           }
       }
       return profit;
    }

}

package main.java.arrays.knapsack;

public class KnapsackProblem {
    public static void main(String[] args) {
        int w = 3;
        int profit[] = {1, 2, 3};
        int weight[] = {4, 5, 6};
        System.out.println(maxProfit(w, profit, weight, 0));
    }

    /**
     * Given n items where each item has some weight and profit associated with it and also given a bag with capacity W,
     * [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of
     * profits associated with them is the maximum possible.
     * Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not
     * possible to put a part of an item into the bag].
     * Input:  W = 4, profit[] = [1, 2, 3], weight[] = [4, 5, 1]
     * Output: 3
     * Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4,
     * the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum
     * possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the
     * bag is 4.
     * Input: W = 3, profit[] = [1, 2, 3], weight[] = [4, 5, 6]
     * Output: 0
     */
    public static int maxProfit(int w, int[] profit, int[] weight,int index){
        int picked =0;
        int notPicked =0;
        if(index==weight.length || w<=0)
            return 0;
        picked = profit[index] + maxProfit(w-weight[index],profit,weight,index+1);
        notPicked = maxProfit(w,profit,weight,index+1);
        return Math.max(picked,notPicked);
    }
}

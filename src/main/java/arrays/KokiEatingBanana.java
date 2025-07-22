package main.java.arrays;

public class KokiEatingBanana {

    /**
     * Optimize the number of banana by performing binary search on number of banana
     */
    public static void main(String[] args) {
//        int[] piles =  {3,6,7,11};
        int[] piles =  {30,11,23,4,20};
        int minNoOfBananaPerHour = minNoOfDays(piles, 6);
        System.out.println(minNoOfBananaPerHour);
    }

    /**
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats
     * k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any
     * more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     */
    private static int minNoOfDays(int[] piles, int noOfDays) {
        int maxNum=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxNum=Math.max(maxNum,piles[i]);
        }
//        for (int i=1;i<=maxNum;i++){
//            if(isAbleToEat(piles,noOfDays,i)){
//                return i;
//            }
//        }
        int start=1;
        int end=maxNum;
        int mid=1;
        while(start<end){
            mid=(start+end)/2;
            if(isAbleToEatS(piles,noOfDays,mid)){
                if(isAbleToEatS(piles,noOfDays,mid-1))
                    end=mid-1;
                else
                    return mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    private static boolean isAbleToEatS(int[] piles,int noOfDays, int bananaPerHour){
        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+= Math.ceilDiv(piles[i],bananaPerHour);
        }
        return sum<=noOfDays;
    }

    public int minEatingSpeed(int[] piles, int h){
        int maxNum=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxNum=Math.max(maxNum,piles[i]);
        }
        int start=1;
        int end=maxNum;
        int mid=1;
        while(start<=end){
            mid=(start+end)/2;
            if(isAbleToEat(piles,h,mid)){
                if(isAbleToEat(piles,h,mid-1))
                    end=mid-1;
                else
                    return mid;
            } else
                start = mid+1;
        }
        return -1;
    }
    private boolean isAbleToEat(int[] piles,int noOfDays, int bananaPerHour){
        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+= Math.ceilDiv(piles[i],bananaPerHour);
        }
        return sum<=noOfDays;
    }

}

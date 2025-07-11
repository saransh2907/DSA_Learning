package main.java.arrays;

import java.util.Arrays;

public class WaterCollect {

    public static void main(String[] args) {
//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] heights = {4,2,0,3,2,5};
        System.out.println(Arrays.toString(heights));
        int collectedWater = trap(heights);
        System.out.println(collectedWater);
        heights = new int[] {1,8,6,2,5,4,8,3,7};
        int maxContainerWater = containerWithMostWter(heights);
        System.out.println(maxContainerWater);
    }
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     * Example 1:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     * Example 2:
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     */
    public static int trap(int[] height) {
        int totalWater=0;
        int[] maxFromRight = new int[height.length];
        int max = height[height.length-1];
        for(int i = height.length-1;i >= 0; i--){
            max = Math.max(max,height[i]);
            maxFromRight[i] = max;
        }
        max = height[0];
        for(int i =1; i < height.length; i++){
            max = Math.max(max,height[i]);
            int waterLevel = Math.min(max,maxFromRight[i]);
            if(waterLevel > height[i]){
                totalWater += waterLevel - height[i];
            }
        }
        return totalWater;
    }

    /**
     * 8 8 8 8 8 8 8 7 7 maxFromRight
     * 1 8 8 8 8 8 8 8 8 maxFromLeft
     * 1 8 8 8 8 8 8 7 7 waterlevel = Min(maxFromRight,maxFromLeft)
     *
     * 0 0 2 6 3 4 0 4 0
     * 1 8 6 2 5 4 8 3 7
     *
     * @param height
     * @return
     */
    public static int containerWithMostWter(int[] height) {
        int totalWater=0;
        int maxWaterContainer = 0;
        for(int i =1; i < height.length; i++){
           for(int j = height.length-1; j >0; j--){
               int waterLevel = Math.min(height[i], height[j]);
               totalWater = (j-i) * waterLevel;
               maxWaterContainer = Math.max(totalWater, maxWaterContainer);
           }
        }
        return maxWaterContainer;
    }
}

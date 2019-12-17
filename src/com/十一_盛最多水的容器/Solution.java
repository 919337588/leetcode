package com.十一_盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        Integer max=-1;
        while(j>i){
            if (height[j] > height[i]) {
                int t=(j-i)*height[i];
                max=t>max?t:max;
                i++;
            } else {
                int t=(j-i)*height[j];
                max=t>max?t:max;
                j--;
            }
        }
        return max;
    }
}
package com.tiku.十六_最接近的三数之和;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int []{-1,2,1,-4},1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,s=0;
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || i > 0 && nums[i] != nums[i-1]){//nums[i] != nums[i-1] 去重
                int l = i+1, r = nums.length-1;
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target){
                       return sum;
                    }else if (sum > target){
                        while(l < r && nums[r] == nums[r-1]) r--;//去重
                        r--;
                    }
                    else {
                        while(l < r && nums[l] == nums[l+1]) l++;//去重
                        l++;
                    }
                    int a=Math.abs(sum-target);
                    if(a<min){
                        min=a;
                        s=sum;
                    }
                }
            }
        }
        return s;
    }
}
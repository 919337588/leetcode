package com.剑指offer.数组中重复的数字;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(hashMap.containsKey(nums[i])){
                return nums[i];
            }
            hashMap.put(nums[i],true);
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <nums.length ; i++) {
           if(nums[i]==nums[i-1]){
               return nums[i];
           }
        }
        return 0;
    }

}
package com.十五_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{3,0,-2,-1,1,2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re=new LinkedList<>();
        HashMap<Integer,HashMap<Integer,Boolean>> qc=new HashMap<>();
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],i);
        }
        for (int i = 1; i <nums.length-1 ; i++) {
            for(int j=0;j<i;j++){
                if(j>0&&nums[j]==nums[j-1]){
                    continue;
                }
                Integer need=-1*(nums[j]+nums[i]);
               Integer set=map.get(need);
                if(set!=null&&set>i){
                    HashMap<Integer,Boolean> integers = qc.get(nums[j]);
                    if(integers==null){
                        re.add(Arrays.asList(nums[j],nums[i],need));
                        integers=new HashMap<>();
                        integers.put(nums[i],true);
                        qc.put(nums[j],integers);
                    }else if(!integers.containsKey(nums[i])){
                        re.add(Arrays.asList(nums[j],nums[i],need));
                        integers.put(nums[i],true);
                    }
                }
            }
        }
        return re;
    }

}
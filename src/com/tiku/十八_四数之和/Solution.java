package com.tiku.十八_四数之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || j > i + 1 && nums[j] != nums[j - 1]) {
                        //nums[i] != nums[i-1] 去重
                        int l = j + 1, r = nums.length - 1;
                        while (l < r) {
                            int sum = nums[i] +nums[j] + nums[l] + nums[r];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) l++;
                                while (l < r && nums[r] == nums[r - 1]) r--;//去重
                                l++;
                                r--;
                            } else if (sum > target) {
                                while (l < r && nums[r] == nums[r - 1]) r--;//去重
                                r--;
                            } else {
                                while (l < r && nums[l] == nums[l + 1]) l++;//去重
                                l++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}

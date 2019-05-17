package com.TwoSum;

import java.util.*;
/**Two Sum
 * 两个总和
 *
 *
 * 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。
 *
 * 您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
 *
 * 例：
 *
 * 给定nums = [2,7,11,15]，target = 9，
 *
 * 因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
 * 返回[ 0，1 ]。
 * */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        Arrays.stream(new Solution().twoSum(nums,target)).forEach(System.out::println);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

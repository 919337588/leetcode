package com.MedianOfTwoSortedArrays;

import java.util.*;
/**
 *Median of Two Sorted Arrays
 * 两个排序数组的中位数
 *
 *有两个排序的数组nums1和nums2分别为m和n。
 *
 * 找到两个排序数组的中位数。总运行时间复杂度应为O（log（m + n））。
 *
 * 您可以假设nums1和nums2  不能都为空。
 *
 * 例1：
 *
 * nums1 = [1,3]
 * nums2 = [2]
 *
 * 中位数是2.0
 * 例2：
 *
 * nums1 = [1,2]
 * nums2 = [3,4]
 *
 * 中位数为（2 + 3）/ 2 = 2.5
 * */
public class Solution {

    public static void main(String[] args) {
        int[] num1=new int[]{1,3};
        int[] num2=new int[]{2};
        System.out.println(new Solution().findMedianSortedArrays(num1,num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] as=new int[nums1.length+nums2.length];
        int is=0;
        for(int i:nums1){
            as[is++]=i;
        }
        for(int i:nums2){
            as[is++]=i;
        }
        Arrays.sort(as);
        int a=as.length/2;
        int b=as.length%2;
        if(b==0){
            return Double.valueOf(as[a]+as[a-1])/2;
        }else{
            return Double.valueOf(as[a]);
        }
    }
}

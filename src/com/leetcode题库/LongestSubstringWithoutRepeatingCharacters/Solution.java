package com.leetcode题库.LongestSubstringWithoutRepeatingCharacters;
/**
 Longest Substring Without Repeating Characters
 * 没有重复字符的最长子串
 *
 *给定一个字符串，找到最长子字符串的长度而不重复字符。
 *
 * 例1：
 *
 * 输入：“abcabcbb”
 * 输出：3
 *  说明：答案是"abc"，长度为3。
 * 例2：
 *
 * 输入：“BBBBB”
 * 输出：1
 *  说明：答案是"b"，长度为1。
 * 例3：
 *
 * 输入：“pwwkew”
 * 输出：3
 *  说明：答案是"wke"，长度为3。
 *              请注意，答案必须是子字符串，"pwke"是子序列而不是子字符串。
 * */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));

    }
    public int lengthOfLongestSubstring(String s) {
        char[] v=s.toCharArray();
        int length=-1;
        int max=0;
        for(int i=0;i<v.length;i++){
            if(i==0){
                length=1;
                max=1;
            }else{
                int ind=-1;
                for(int j=i-1;j>=i-length;j--){
                    if(v[i]==v[j]){
                        ind=j-(i-length);
                        break;
                    }
                }
                if(ind==-1){
                    length=length+1;
                }else{
                    length=length-ind;
                }
                max=max>length?max:length;
            }
        }
    return max;
    }
}

package com.tiku.LongestPalindromicSubstring;


/**
 * Longest Palindromic Substring
 * 给定一个字符串小号，发现最长的回文子小号。您可以假设s的最大长度为1000。
 * <p>
 * 例1：
 * <p>
 * 输入： “babad”
 * 输出： “bab”
 * 注意： “aba”也是一个有效的答案。
 * 例2：
 * <p>
 * 输入： “cbbd”
 * 输出： “bb”
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
    public String longestPalindrome(String s) {
        char[] a = s.toCharArray();
         int[] ov=new int[]{0,a.length>0?1:0};
        for (int i = 0; i < a.length; i++) {
             tomax(i-1,i+1,a,false,ov);
             tomax(i-1,i,a,false,ov);
        }
        return s.substring(ov[0],ov[1]+ov[0]);
    }
    public void tomax(int b,int o,char[] a,boolean begin,int[] ov){
        if((b<0||o>=a.length||a[b]!=a[o])){
            if(begin){
                int aa=o-b-1;
                if(aa>ov[1]){
                    ov[0]=++b;
                    ov[1]=aa;
                }
            }

        }else {
            tomax(--b,++o,a,true,ov);
        }
    }
}

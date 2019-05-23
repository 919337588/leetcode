package com.ReverseInteger;
/**
 Reverse Integer
 反向整数
给定32位有符号整数，整数的反向数字。

例1：

输入： 123
 输出： 321
例2：

输入： -123
 输出： -321
例3：

输入： 120
 输出： 21*/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
    public int reverse(int x) {
        StringBuilder stringBuilder=new StringBuilder(x>=0?"":"-");
        x=Math.abs(x);
        while(x>10){
            stringBuilder.append(x%10);
            x=x/10;
        }
       return Integer.valueOf(stringBuilder.append(x).toString());
    }
}
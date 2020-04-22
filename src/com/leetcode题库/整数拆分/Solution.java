package com.leetcode题库.整数拆分;

class Solution {
    public int integerBreak(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        long res = 1;
        while(n > 4) {
            res *= 3;
            n -= 3;
        }
        return (int)(res * n);
    }
}
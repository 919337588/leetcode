package com.十二_整数转罗马数字;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
    }
    public String intToRoman(int num) {
        Object[][] list = new Object[][]{{"M", 1000},
                {"M", 1000},
                {"CM", 900},
                {"D", 500},
                {"CD", 400},
                {"C", 100},
                {"XC", 90},
                {"L", 50},
                {"XL", 40},
                {"X", 10},
                {"IX", 9},
                {"V", 5},
                {"IV", 4},
                {"I", 1}};
        int i=1;
        StringBuilder s=new StringBuilder();
        while(num>0){
            while(num<(int)list[i][1]){
                i++;
            }
            int size=num/(int)list[i][1];
            num=num%(int)list[i][1];
            if(size>0){
                for(int k=0;k<size;k++){
                    s.append((String)list[i][0]);
                }
            }

        }
        return s.toString();

    }
}
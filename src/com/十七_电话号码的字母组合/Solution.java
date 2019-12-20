package com.十七_电话号码的字母组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()<1){
            return new ArrayList<>();
        }
        char[][] a=new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<String> v=new LinkedList<String>();
        char[] num=digits.toCharArray();
        add(v,a,num,0,"");
        return v;
    }
    public void add(List<String> i, char[][] a,char[]num,int index,String s){
        if(index>=num.length){
            i.add(s);
            return;
        }
        char[] is=a[num[index]-'0'];
        for(char ch:is){
            add(i,a,num,index+1,s+ch);
        }

    }
}
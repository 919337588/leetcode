package com.tiku.二十二_括号生成;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new LinkedList<>();

        add(list,0,n,0,2*n,"");
        return list;
    }
    public void add(List<String> list,int si,int n,int l,int s,String a){
        if(l==s){
            list.add(a);
            return;
        }
        if(n>0){
            if(si>0){
                add(list,si-1,n,l+1,s,a+")");
            }
            add(list,si+1,n-1,l+1,s,a+"(");

        }else{
            if(si>0){
                add(list,si-1,n,l+1,s,a+")");
            }
        }
    }
}
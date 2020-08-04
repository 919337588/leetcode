package com.剑指offer.字符串的排列;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    List<String> linklist=new LinkedList<>();
    public String[] permutation(String s) {
        if(s.length()<=1){
            return new String[]{s};
        }
        dd(s.toCharArray(),new char[s.length()],0,new boolean[s.length()]);
        return  linklist.toArray(new String[linklist.size()]);
    }

    public void dd(char[] a,char[] s,int chari,boolean[] v){
        if(chari==s.length-1){
            for (int j = 0; j < v.length; j++) {
                if(v[j]){
                    continue;
                }
                s[chari]=a[j];
                linklist.add(new String(s));
                break;
            }

            return;
        }
        Map<Character ,Boolean> map=new HashMap<>();
        for (int j = 0; j < v.length; j++) {
            if(v[j]||map.containsKey(a[j])){
                continue;
            }
            v[j]=true;
            s[chari]=a[j];
            map.put(a[j],true);
            dd(a,s,chari+1,v);
            v[j]=false;
        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Solution().permutation("123456789")).forEach(System.out::println);
    }
}
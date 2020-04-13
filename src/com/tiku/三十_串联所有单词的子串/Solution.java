package com.tiku.三十_串联所有单词的子串;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("11",new String[]{"sdfdsf","56412ds3fdsf","5s1dfda","ds1f56d4fasd5asf"}));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int lenght=0;
        for(int i=0;i<words.length;i++){
            lenght+=words[i].length();
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[j].length()>words[i].length()){
                    String max=words[j];
                    words[j]=words[i];
                    words[i]=max;
                }
            }
        }
        int[] is=new int[s.length()];
//        s.split()
        return null;
    }
}
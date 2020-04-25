package com.跟谁学面试题;

//1、	给定2个字符串，S1，S2，求S1、S2的最长公共子序列，如：
//        S1=abcdefghijklmnopqrstuvwxyz
//        S2=abdefhijkjklmn
//        则输出为：abdefhijkmn

import java.util.LinkedList;

public class QuestionOne {
   static String[][] hc;
    public static void main(String[] args) {
        String a="abcdefghijklmnopqrstuvwxyz";
        String b="abdefhijkjklmn";
        hc=new String[a.length()][b.length()];
        System.out.println(find(a.toCharArray(),b.toCharArray(),0,0));
    }

    public static String find(char[] s1, char[] s2, int s1i, int s2i){
        if(s1i>=s1.length||s2i>=s2.length){
            return "";
        }
        if(hc[s1i][s2i]!=null){
            return hc[s1i][s2i];
        }
        String vals;
        if(s1[s1i]==s2[s2i]){
            vals =s1[s1i]+find(s1,s2,s1i+1,s2i+1);
            String  vals1 =find(s1,s2,s1i,s2i+1);
            String  vals2 =find(s1,s2,s1i+1,s2i);
            vals=vals1.length()>vals.length()?vals1:vals;
            vals=vals2.length()>vals.length()?vals2:vals;
        }else{
            String as= find(s1,s2,s1i+1,s2i);
            String ab= find(s1,s2,s1i,s2i+1);
            vals=as.length()>ab.length()?as:ab;
        }
        return hc[s1i][s2i]=vals;
    }
}

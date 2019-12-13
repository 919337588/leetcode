package com.八_字符串转换整数;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtois("20000000000000000000"));
    }
    List<Character> as=Arrays.asList('+','-');
    List<Character> num=Arrays.asList('1','2','3','4','5','6','7','8','9','0');
    public int myAtoi(String str) {
        char[] a=str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        boolean isbegin=false,havenume=false;
        for(int i=0;i<a.length;i++){
            if(!isbegin){
                if(as.contains(a[i])){
                    isbegin=true;
                    stringBuilder.append(a[i]);
                }else if(num.contains(a[i])){
                    isbegin=true;
                    if(!havenume&&a[i]=='0'){
                        continue;
                    }
                    havenume=true;
                    stringBuilder.append(a[i]);
                }else if(a[i]!=' '){
                    break;
                }
            }else{
                if(num.contains(a[i])){
                    if(!havenume&&a[i]=='0'){
                        continue;
                    }
                    havenume=true;
                    stringBuilder.append(a[i]);
                }else{
                    break;
                }
            }
        }
        if(!havenume){
            return 0;
        }
        String ss=stringBuilder.toString().trim().replace("+","");
        if(ss.length()>13){
            ss=ss.substring(0,13);
        }
        Long b=Long.valueOf(ss);
        if(b>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(b<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return b.intValue();
    }
    public int myAtois(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        int i = 0;
        //2.判断数字的符号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                break;
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10)
                return Integer.MAX_VALUE;
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10)
                return Integer.MAX_VALUE;
            if (flag < 0 && -res < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + ch - '0';
        }
        return res * flag;
    }
}

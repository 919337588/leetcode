package com.跟谁学面试题;

public class QuestionTwo {
    public static void main(String[] args) {
        String a="This is a test";
        char[] chars = a.toCharArray();
        int s=chars.length;
        for (int i = chars.length-1; i >-2 ; i--) {
           if(i==-1||chars[i]==' '){
               for (int j = i+1; j <s ; j++) {
                   System.out.print(chars[j]);
               }
               System.out.print(' ');
               s=i;
           }
        }
    }
}

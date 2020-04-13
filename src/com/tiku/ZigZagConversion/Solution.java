package com.tiku.ZigZagConversion;


/**ZigZag Conversion
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 * */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("A",1));
    }

    public String convert(String s, int numRows) {

        StringBuilder stringBuilder=new StringBuilder();
        char[] a=s.toCharArray();
        for(int i=0;i<numRows;i++){
            int b=Math.abs(numRows-i)-1;
            b=b==0?numRows-(b+1):b;
            int c=numRows-(b+1);
            c=c==0?numRows-(c+1):c;
            int t=c;
            if(t==0){
                return s;
            }
            for(int j=i;j<a.length;j=j+t*2){
                stringBuilder.append(a[j]);
               t=t==b?c:b;
            }
        }
        return stringBuilder.toString();
    }
}

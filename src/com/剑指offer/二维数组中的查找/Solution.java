package com.剑指offer.二维数组中的查找;

class Solution {
    public static void main(String[] args) {
        System.out.println( new Solution().findNumberIn2DArray(new int[][]{{1,3,5}},5));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length>0&&matrix[i][0]<=target&&matrix[i][matrix[i].length-1]>=target){
                if(find(matrix[i],target,matrix[i].length/2,0,matrix[i].length-1))return true ;
            }
        }
        return  false;
    }
    public boolean find(int[] num,int val,int index,int left,int right){
        if(num[index]==val){
            return true;
        }else{
            if(num[index]>val){
                if(index-left==1){
                    return num[left]==val;
                }
                return find(num,val,(index+left)/2,left,index);
            }else{
                if(right-index==1){
                    return num[right]==val;
                }
                return find(num,val,(right+index)/2,index,right);
            }
        }
    }
}
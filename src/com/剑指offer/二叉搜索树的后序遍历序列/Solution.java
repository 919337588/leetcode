package com.剑指offer.二叉搜索树的后序遍历序列;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0){
            return true;
        }
        return find(postorder,0,postorder.length-1,null,null);

    }
    public boolean find(int[] p,int i,int j,Integer max,Integer min){
        if(i<=j&&((max!=null&&p[j]>max)||(min!=null&&p[j]<min))){
            return false;
        }
        if(j<=i){
            return true;
        }
        for (int m=j-1;m>=i;m--){
            if(p[m]<p[j]){
                return find(p,m+1,j-1,max,min==null||p[j]>min?p[j]:min)&&find(p,i,m,max==null||p[j]<max?p[j]:max,min);
            }
        }
        return find(p,i,j-1,max,min==null||p[j]>min?p[j]:min);
    }

}
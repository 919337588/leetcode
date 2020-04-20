package com.剑指offer.树的子结构;


class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(A==null|| B==null){
            return false;
        }

        if(A.val== B.val){
            if(find(A,B)){
                return true;
            }
        }



        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean find(TreeNode A, TreeNode B) {
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val== B.val){
            return find(A.left, B.left)&&find(A.right, B.right);
        }
        else{
            return false;
        }


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
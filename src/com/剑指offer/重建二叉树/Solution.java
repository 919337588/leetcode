package com.剑指offer.重建二叉树;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{1,2}, new int[]{2,1});

        System.out.println(treeNode);
    }
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
       return build(0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode build(int pb,int po,int ib,int io){
        if(pb>po || ib>io) {
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[pb]);
        for (int i = ib; i <=io ; i++) {
            if(inorder[i]==preorder[pb]){
                int j=i-ib+pb;
                treeNode.left=build(pb+1,j,ib,i-1);
                treeNode.right=build(j+1,po,i+1,io);

            }
        }
        return treeNode;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
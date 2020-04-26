package com.剑指offer.从上到下打印二叉树;

import com.剑指offer.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        treeNode.left.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(5);
        Arrays.stream(new Solution().levelOrder(treeNode)).forEach(System.out::print);
        HashMap hashMap=new HashMap();
        hashMap.put(null,"");
    }


    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        return level(new ArrayList<TreeNode>(){{add(root);}},0);

    }
    public int[] level(List<TreeNode> vector,int k){
        if(k>=vector.size()){
            int[] l=new int[vector.size()];
            int i=0;
            Iterator<TreeNode> iterator = vector.iterator();
            while (iterator.hasNext()){
                l[i++]=iterator.next().val;
            }
            return l;
        }
       TreeNode treeNode= vector.get(k);
        if(treeNode.left!=null){
            vector.add(treeNode.left);
        }
        if(treeNode.right!=null){
            vector.add(treeNode.right);
        }
    return level(vector,k+1);

    }



}
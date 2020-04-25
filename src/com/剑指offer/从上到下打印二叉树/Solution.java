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
        String a = "hello";
        String b = "hello";
        System.out.println(a==b);
        String c = new String("hello");
        System.out.println(a==c);
        StringBuffer d = new StringBuffer("hello");
        System.out.println(a==d.toString());
        String e = "he" + "llo";
        System.out.println(b==e);
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
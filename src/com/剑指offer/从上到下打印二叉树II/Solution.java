package com.剑指offer.从上到下打印二叉树II;

import com.剑指offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        new Solution().levelOrder(treeNode).forEach(System.out::println);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        find(root,lists,0);
        return lists;
    }
    public  void find(TreeNode treeNode,List<List<Integer>> lists,int i){
        if(treeNode==null){
            return;
        }
        List<Integer> linkedList;
        if(i<lists.size()) {
            linkedList =lists.get(i);
            linkedList.add(treeNode.val);
        }else{
            linkedList=new LinkedList<>();
            linkedList.add(treeNode.val);
            lists.add(linkedList);
        }
        find(treeNode.left,lists,i+1);
        find(treeNode.right,lists,i+1);
    }
}
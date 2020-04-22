package com.leetcode题库.二叉树的层序遍历;

import com.leetcode题库.TreeNode;

import java.util.ArrayList;
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
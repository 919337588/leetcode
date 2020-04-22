package com.leetcode题库.路径总和II;

import com.leetcode题库.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> lists=new LinkedList<>();
        pathSum(root,sum,0,new LinkedList<>(),lists);
        return lists;
    }
    public void pathSum(TreeNode root, int sum,int i, LinkedList<Integer> linkedList,List<List<Integer>> lists) {
        if(root!=null){
            linkedList.add(root.val);
            int isum=i+root.val;
            if(root.left==null&&root.right==null){
                if(isum==sum){
                    lists.add((List<Integer>)linkedList.clone());
                }
            }else{
                pathSum(root.left,sum,isum,linkedList,lists);
                pathSum(root.right,sum,isum,linkedList,lists);
            }
            linkedList.removeLast();
        }

    }

}
package com.剑指offer.序列化二叉树;

import com.剑指offer.TreeNode;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return level(new ArrayList<TreeNode>(){{add(root);}},0).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }




    public List<TreeNode> level(List<TreeNode> vector, int k){
        if(k>=vector.size()){
            return vector;
        }
        TreeNode treeNode= vector.get(k);
        if(treeNode!=null){
            vector.add(treeNode.left);
            vector.add(treeNode.right);
        }
        return level(vector,k+1);

    }
}

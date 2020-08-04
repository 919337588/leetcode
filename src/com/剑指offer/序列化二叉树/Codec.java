package com.剑指offer.序列化二叉树;

import com.剑指offer.TreeNode;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        StringBuilder stringBuilder=new StringBuilder();
         level(new ArrayList<TreeNode>(){{add(root);}},0).stream().forEach(v->stringBuilder.append(",").append(v==null?"n":v.val));
         return stringBuilder.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        String[] strings=data.split(",");
        TreeNode treeNode=new TreeNode(Integer.valueOf(strings[0]));
        level2(new ArrayList<TreeNode>(strings.length){{add(treeNode);}},strings,0,1);
        return treeNode;
    }


    public void level2(List<TreeNode> vector,String[] strings, int k,int i){
        if(k>=vector.size()||i>=strings.length){
            return ;
        }
        TreeNode treeNode= vector.get(k);
        if(!strings[i].equals("n")){
            treeNode.left=new TreeNode(Integer.valueOf(strings[i]));
            vector.add(treeNode.left);
        }
        i+=1;
        if(!strings[i].equals("n")){
            treeNode.right=new TreeNode(Integer.valueOf(strings[i]));
            vector.add(treeNode.right);
        }
        i+=1;
         level2(vector,strings,k+1,i);

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

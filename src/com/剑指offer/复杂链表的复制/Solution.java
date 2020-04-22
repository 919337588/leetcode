package com.剑指offer.复杂链表的复制;

import com.剑指offer.Node;

import java.util.HashMap;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node node=head;
        Node copyh=null;
        HashMap<Node,Node> hashMap=new HashMap<>();
        Node node1=null;
        while(node!=null){
            if(node1==null){
                node1 = genode(node,hashMap,node);
            }else{
                node1.val=node.val;
            }
            if(copyh==null){
                copyh=node1;
            }

            if(node.next!=null){
                node1.next= genode(node.next,hashMap,null);
            }
            if(node.random!=null){
                node1.random= genode(node.random,hashMap,null);
            }
            node=node.next;
            node1=node1.next;
        }
        return copyh;
    }
    public Node genode(Node ns,HashMap<Node,Node> hashMap,Node node){
        Node node1 = hashMap.get(ns);
        if(node1==null){
            node1=new Node(node==null?1:node.val);
            hashMap.put(ns,node1);
        }else{
            if(node!=null){
                node1.val=node.val;
            }

        }
        return node1;
    }
}
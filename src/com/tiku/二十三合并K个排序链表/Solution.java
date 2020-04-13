package com.tiku.二十三合并K个排序链表;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode listNodea1=new ListNode(1);
        ListNode listNodea4=new ListNode(4);
        ListNode listNodea5=new ListNode(5);
        listNodea1.next=listNodea4;
        listNodea4.next=listNodea5;
        ListNode listNodeb1=new ListNode(1);
        ListNode listNodeb3=new ListNode(3);
        ListNode listNodeb4=new ListNode(4);
        listNodeb1.next=listNodeb3;
        listNodeb3.next=listNodeb4;
        ListNode listNodec2=new ListNode(2);
        ListNode listNodec6=new ListNode(6);
        listNodec2.next=listNodec6;
        ListNode listNode=new Solution().mergeKLists(new ListNode[]{});
        System.out.println(1);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes=new ArrayList<>();
        for(ListNode lists1:lists){
            add(listNodes,lists1);
        }
        ListNode head=new ListNode(1);
        ListNode sg=head;
        while(listNodes.size()>0){
            ListNode b=listNodes.remove(0);
            sg.next=b;
            sg=b;

                add(listNodes,b.next);


        }
        return head.next;
    }
    public void add(List<ListNode> listNodes,ListNode lists1){
        if(lists1==null){
            return;
        }
        if(listNodes.size()==0){
            listNodes.add(lists1);
        }else{
            int i=0;
            for(ListNode listNode:listNodes){
                if(lists1.val<=listNode.val){
                    listNodes.add(i,lists1);
                    return;
                }
                i++;
            }
            listNodes.add(lists1);
        }
    }
    public static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
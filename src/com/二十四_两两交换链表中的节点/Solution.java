package com.二十四_两两交换链表中的节点;

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
        ListNode listNodea2=new ListNode(2);
        ListNode listNodea3=new ListNode(3);
        ListNode listNodea4=new ListNode(4);
        listNodea1.next=listNodea2;
        listNodea2.next=listNodea3;
        listNodea3.next=listNodea4;
        new Solution().swapPairs(listNodea1);
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode first=head.next!=null?head.next:head;
        ListNode d=head,fater=null;
        while(d!=null&&d.next!=null){
            ListNode listNode=d.next;
            d.next=d.next.next;
            listNode.next=d;
            if(fater!=null){
                fater.next=listNode;
            }
            fater=d;
            d=d.next;
        }
        return first;
    }
    public static class ListNode {
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
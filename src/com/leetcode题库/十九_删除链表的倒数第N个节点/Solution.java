package com.leetcode题库.十九_删除链表的倒数第N个节点;

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
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
        new Solution().removeNthFromEnd(listNode1,2);
        System.out.println(1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list=new ListNode(1);
        list.next=head;

     return dg(head,n,list,1,head);
    }
    public ListNode dg(ListNode node,int n,ListNode dq,int b,ListNode head){
            if(node.next==null){
                if(b>=n){
                    if(dq.next==head){
                        return head.next;
                    }else{
                        dq.next=dq.next.next;
                        return head;
                    }
                }else{
                    return head;
                }
            }else{
                return dg(node.next,n,n<=b?dq.next:dq,b+1,head);
            }
    }

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
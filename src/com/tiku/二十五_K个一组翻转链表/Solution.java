package com.tiku.二十五_K个一组翻转链表;

public class Solution {
    public static void main(String[] args) {
        ListNode listNodea1=new ListNode(1);
        ListNode listNodea2=new ListNode(2);
        ListNode listNodea3=new ListNode(3);
        ListNode listNodea4=new ListNode(4);
//        listNodea1.next=listNodea2;
//        listNodea2.next=listNodea3;
//        listNodea3.next=listNodea4;
        new Solution().reverseKGroup(listNodea1,2);
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null){
            return null;
        }
        ListNode first=null;
        ListNode d=head,fater=null;
        while(d!=null&&havenext(d,k)){
            ListNode listNode=fz(null,d,d,k);
            first=first==null?listNode:first;
            if(fater!=null){
                fater.next=listNode;
            }
            fater=d;
            d=d.next;
        }
        return first==null?head:first;
    }
    ListNode fz(ListNode fater,ListNode d,ListNode d2,int k){
        if(k==0){
            d2.next=d;
            return fater;
        }else{
            ListNode listNode=d.next;
            d.next=fater;
            return  fz(d,listNode,d2,k-1);
        }
    }
    boolean havenext(ListNode listNode,int k){
        if(k==1){
            if(listNode!=null){
                return true;
            }else{
                return false;
            }
        }else if(listNode ==null){
            return false;
        }
        return havenext(listNode.next,k-1);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

package com.leetcode题库.AddTwoNumbers;

public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    @Override
    public String toString() {
        return val+(next==null?"":"->"+next.toString());
    }
}
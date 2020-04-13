package com.tiku.AddTwoNumbers;

/**
 Add Two Numbers
 * 添加两个数字
 *
 *
 * 您将获得两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链接列表返回。
 *
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 *
 * 例：
 *
 * 输入：（2  - > 4  - > 3）+（5  - > 6  - > 4）
 *  输出： 7  - > 0  - > 8
 *  说明： 342 + 465 = 807。
 * */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode1=new ListNode(1);
        ListNode listNode7=new ListNode(7);
        listNode3.next=listNode2;
        listNode7.next=listNode1;
        System.out.println(  new Solution().addTwoNumbers(new ListNode(5),new ListNode(5)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add=0;
        ListNode first=null;
        ListNode now=null;
        while(l1!=null||l2!=null){
                int ival=(l1==null?0:l1.val)+(l2==null?0:l2.val)+add;
                add=0;
                if(ival>=10){
                    add=ival/10;
                    ival=ival%10;
                }
                ListNode listNode=new ListNode(ival);
                if(first==null){
                    first=listNode;
                    now=listNode;
                }else{
                    now.next=listNode;
                    now=listNode;
                }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(add!=0){
            now.next=new ListNode(add);
        }
       return first;
    }
}

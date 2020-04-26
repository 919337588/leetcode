package com.字节跳动面试题;

import java.util.Scanner;
public class Main {
    static class Node{
        Integer val;
        Node next;
        public Node(Integer val){
            this.val=val;
        }
    }
    static class List{
        Node first;
        Node last;
        List(Node first,Node last){
            this.first=first;
            this.last=last;
        }
        public String toString(){
            Node node=first;
            String a="";
            while(node!=null){
                a=a+" "+node.val;
                node=node.next;
            }
            return a;
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.next=new Node(2);
        
        Node node2=new Node(9);
        node2.next=new Node(7);
        
        System.out.println(addNum(new List(node,node.next),new List(node2,node2.next)));
    }
    public static List addNum(List a,List b){
        Node node1=a.first;
        Node node2=b.first;
        Node node3=new Node(null);
        Node last=add(node1,node2,node3,false);
        return new List(node3.next,last);
        
        
    }
    public  static Node add(Node a,Node b,Node c,Boolean type){
        if(a==null||b==null){
             a=a!=null?a:b!=null?b:null;
            if(type){
                if(a!=null){
                    int val=a.val+1;
                    if(val>=10){
                        Node node=new Node(10);
                        c.next=node;
                        node.next=new Node(val%10);
                        return node.next;
                    }else{
                         Node node=new Node(val);
                        c.next=node;
                        return node;
                    }
                    
                }else{
                    Node node=new Node(1);
                    c.next=node;
                    return node;
                }
                
            }else{
                if(a!=null){
                    Node node=new Node(a.val);
                        c.next=node;
                    return node;
                }
                return c;
            }
            
        }
        else{
            Integer val=a.val+b.val;
            if(type){
                val+=1;
            }
            Boolean ba=val>=10;
            val=val%10;
            Node node=new Node(val);
            c.next=node;
            return add(a.next,b.next,c.next,ba);
        }
    }
}
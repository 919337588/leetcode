package com.剑指offer.栈的压入弹出序列;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack =new Stack<>();
        Integer index=0;
        for (int i = 0; i <pushed.length ; i++) {
            stack.push(pushed[i]);
                while (!stack.empty()&&stack.peek()==popped[index]){
                    stack.pop();
                    index++;
                }
        }
        return stack.empty();
    }
}
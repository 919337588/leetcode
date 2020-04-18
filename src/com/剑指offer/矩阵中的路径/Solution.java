package com.剑指offer.矩阵中的路径;

class Solution {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[1];
        System.out.println(new Solution().exist(new char[][]{{'a'}},"b"));
    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if(board[i][j]==chars[0]){
                    booleans[i][j]=true;
                    if(find(board,booleans,chars,i,j,1))return true;
                    booleans[i][j]=false;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board,boolean[][] bind,char[] l,int i,int j,int li){
        if(li==l.length){
            return true;
        }
        if(i>0&&!bind[i-1][j]&&board[i-1][j]==l[li]){
            bind[i-1][j]=true;
            if(find(board,bind,l,i-1,j,li+1))return true;
            bind[i-1][j]=false;
        }
        if(i<board.length-1&&!bind[i+1][j]&&board[i+1][j]==l[li]){
            bind[i+1][j]=true;
            if(find(board,bind,l,i+1,j,li+1))return true;
            bind[i+1][j]=false;
        }
        if(j>0&&!bind[i][j-1]&&board[i][j-1]==l[li]){
            bind[i][j-1]=true;
            if(find(board,bind,l,i,j-1,li+1))return true;
            bind[i][j-1]=false;
        }
        if(j<board[i].length-1&&!bind[i][j+1]&&board[i][j+1]==l[li]){
            bind[i][j+1]=true;
            if(find(board,bind,l,i,j+1,li+1))return true;
            bind[i][j+1]=false;
        }
        return false;
    }
}
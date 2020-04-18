package com.剑指offer.剪绳子;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(2));;
    }
    Integer[] max;
    public int cuttingRope(int n) {
        max=new Integer[n+1];
        int i = find(n,true);
        return i;
    }
    public int find(int n,boolean isfirst) {
        if(max[n]!=null){
            return max[n];
        }
        int maxv=isfirst?-1:n;
        for(int i=1;i<n;i++){
            int v=i*find(n-i,false);
            if(v>maxv){
                maxv=v;
            }
        }
        max[n]=maxv;
        return maxv;
    }
}
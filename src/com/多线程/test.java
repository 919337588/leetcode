package com.多线程;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test   {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums=new int[]{-7,-6,-5,-3,1,2,3,4,5,6,7,8,9,10};
        int leng=nums.length;
        System.out.println(find(nums,0,(leng-0)/2,leng,null));

        System.out.println("Hello World!");
    }
    public static int find(int[] nums,int bjz,int i,int bjy,Integer before){
        if(before!=null&&Math.abs(before)==Math.abs(nums[i])){
            return Math.abs(before);
        }else{
            if(nums[i]>0){
                return find(nums,bjz,(i-bjz)/2,i,nums[i]);
            }else if(nums[i]<0){
                return find(nums,i,(bjy-i)/2,bjy,nums[i]);
            }else{
                return 0;
            }
        }
    }
}

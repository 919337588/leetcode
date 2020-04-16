package com.多线程.打印零与奇偶数;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==1){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }


}
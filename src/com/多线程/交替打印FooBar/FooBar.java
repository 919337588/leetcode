package com.多线程.交替打印FooBar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    Lock lock=new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    volatile int clout =1;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(clout!=1){
                condition1.await();
            }
            printFoo.run();
            clout=2;
            condition2.signalAll();
            lock.unlock();


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(clout!=2){
                condition2.await();
            }
        	printBar.run();
            clout=1;
            condition1.signalAll();
            lock.unlock();

        }
    }
}
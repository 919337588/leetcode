package com.多线程.按序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    public Foo() {

    }
    Lock lock=new ReentrantLock();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    volatile int clout =1;
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        printFirst.run();
        condition2.signalAll();
        clout++;
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        if(clout!=2){
            condition2.await();
        }
            printSecond.run();
        condition3.signalAll();
        clout++;
        lock.unlock();
        
    }

    public void third(Runnable printThird) throws InterruptedException {

        lock.lock();
        if(clout!=3){
            condition3.await();
        }
        printThird.run();
        clout++;
        lock.unlock();
    }
}
package com.多线程.交替打印字符串;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }
    AtomicInteger atomicInteger=new AtomicInteger(1);
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (atomicInteger.get()<=n){
            int i = atomicInteger.get();
            if(i%3==0&&i%5!=0){
                printFizz.run();
                atomicInteger.getAndIncrement();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (atomicInteger.get()<=n){
            int i = atomicInteger.get();
            if(i%3!=0&&i%5==0){
                printBuzz.run();
                atomicInteger.getAndIncrement();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (atomicInteger.get()<=n){
            int i = atomicInteger.get();
            if(i%3==0&&i%5==0){
                printFizzBuzz.run();
                atomicInteger.getAndIncrement();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (atomicInteger.get()<=n){
            int i = atomicInteger.get();
            if(i%3!=0&&i%5!=0){
                printNumber.accept(i);
                atomicInteger.getAndIncrement();
            }
        }
    }
}
package com.多线程.设计有限阻塞队列;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {

    LinkedList<Integer> linkedList;
    volatile  int max;
     ReentrantLock lock;
    Condition enqueuec;
    Condition dequeuec;
    public BoundedBlockingQueue(int capacity) {
        linkedList=new LinkedList<>();
        max=capacity;
        lock=new ReentrantLock();
        enqueuec=lock.newCondition();
        dequeuec=lock.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
       lock.lock();
       if(max==0){
           enqueuec.await();
       }
       linkedList.add(element);
       max++;
       dequeuec.signal();
       lock.unlock();
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        if(linkedList.size()==0){
            dequeuec.await();
        }
        int v=linkedList.remove(0);
        max--;
        enqueuec.signal();
        lock.unlock();
        return v;
    }
    
    public int size() {
        return linkedList.size();
    }
}
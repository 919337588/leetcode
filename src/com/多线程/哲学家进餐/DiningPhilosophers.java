package com.多线程.哲学家进餐;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    public DiningPhilosophers() {
        
    }
    Semaphore[] semaphore=new Semaphore[]{
            new Semaphore(2), new Semaphore(0), new Semaphore(2), new Semaphore(1), new Semaphore(0)
    };
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        semaphore[philosopher].acquire(2);
        int before=philosopher-1;
        before=before<0?4:before;
        int next=philosopher+1;
        next=next>4?0:next;
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        semaphore[before].release(1);
        semaphore[next].release(1);
    }
}
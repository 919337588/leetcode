package com.多线程.H2O生成;

import java.util.concurrent.Semaphore;
class H2O {

    public H2O() {

    }
    Semaphore o=new Semaphore(0);
    Semaphore h=new Semaphore(2);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();

        releaseHydrogen.run();
        o.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);

        releaseOxygen.run();
        h.release(2);
    }
}
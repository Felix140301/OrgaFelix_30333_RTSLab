package org.example.App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecThread extends Thread {

    Semaphore semaphore1;
    Semaphore semaphore2;
    CyclicBarrier cyclicBarrier;
    int delay;

    public ExecThread(int delay, CyclicBarrier cyclicBarrier, Semaphore semaphore1, Semaphore semaphore2) {
        this.delay = delay;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void action(int delay) {
        synchronized (this) {
            int k = (int) Math.round(Math.random() * delay);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
    }

    public void sleep(int delay) {
        synchronized (this) {
            try {
                Thread.sleep(Math.round(Math.random() * delay) * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {


        System.out.println(this.getName() + " is in state 1");
        this.action(delay);
        while (true) {
            if (semaphore1.tryAcquire(1)) {
                try {
                    System.out.println(this.getName() + " is in state 2");
                    this.action(5);
                    if (semaphore2.tryAcquire(1)) {
                        this.sleep(delay);
                        System.out.println(this.getName() + " is in state 3");
                        semaphore2.release();
                        semaphore1.release();
                    }
                } catch (Exception e) {

                } finally {

                    semaphore1.release();
                }

                this.action(1);
                System.out.println(this.getName() + " is in state 4");

                this.sleep(1);

                try {
                    System.out.println(this.getName() + " is waiting");
                    cyclicBarrier.await();
                    System.out.println(this.getName() + " is in state 1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}

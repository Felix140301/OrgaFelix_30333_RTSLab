package org.example.Ex3;

import java.util.concurrent.Semaphore;


public class ExecutionThread extends Thread{

    Semaphore semaphore;
    int delay;
    public ExecutionThread(int delay, Semaphore semaphore){
        this.delay=delay;
        this.semaphore=semaphore;
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


        while (true) {

            System.out.println(this.getName()+" is in state 1");
            this.action(delay);
            if (semaphore.tryAcquire(1)) {
                System.out.println(this.getName() + " is in state 2");
                System.out.println(this.getName() + " lock released");
                this.sleep(delay);
                this.action(1);
                semaphore.release();
                this.sleep(delay);
                System.out.println(this.getName() + " is in state 3");
                this.action(1);
                System.out.println(this.getName() + " is in state 4");
                this.sleep(1);

            }
            this.sleep(4);
        }
    }
}

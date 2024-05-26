package org.example.Ex2;

import java.util.concurrent.locks.ReentrantLock;

public class ExecutionThread extends Thread{

    ReentrantLock lock1;
    ReentrantLock lock2;
    int delay;
    public ExecutionThread(int delay, ReentrantLock lock1, ReentrantLock lock2){
        this.delay=delay;
        this.lock1=lock1;
        this.lock2=lock2;
    }

    @Override
    public void run() {
            System.out.println(this.getName()+" is in state 1");

        while (true) {
                if (this.lock1.tryLock()) {

                    System.out.println(this.getName() + " is in state 2");
                    System.out.println(this.getName() + " lock released");
                    lock1.unlock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                }
            }
        System.out.println(this.getName()+" is in state 3");
        while (true) {
            if (this.lock2.tryLock()) {

                System.out.println(this.getName() + " is in state 4");
                System.out.println(this.getName() + " lock released");
                lock2.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;


            }else {
                System.out.println("Resource is still locked");
                break;
            }
        }
        System.out.println(this.getName()+" is in state 5");
    }
}

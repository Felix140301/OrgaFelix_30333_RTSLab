package org.example.App1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaphore1= new Semaphore(1);
        Semaphore semaphore2= new Semaphore(1);
        CyclicBarrier cyclicBarrier= new CyclicBarrier(2);

        ExecThread execThread1=new ExecThread(5,cyclicBarrier,semaphore1,semaphore2);
        ExecThread execThread2=new ExecThread(3,cyclicBarrier,semaphore2,semaphore1);


            execThread1.start();
            execThread2.start();


    }
}
package org.example.Ex2;

import org.example.Ex1.Fir;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {

        ReentrantLock lock1=new ReentrantLock();
        ReentrantLock lock2=new ReentrantLock();

        ExecutionThread executionThread1= new ExecutionThread(4,lock1,lock2);
        ExecutionThread executionThread2= new ExecutionThread(4,lock2,lock1);

        executionThread1.start();
        executionThread2.start();

    }
}

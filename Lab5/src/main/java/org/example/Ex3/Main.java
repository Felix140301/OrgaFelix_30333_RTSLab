package org.example.Ex3;


import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String args[]) {

        Semaphore semaphore= new Semaphore(2);

        ExecutionThread executionThread1= new ExecutionThread(5,semaphore);
        ExecutionThread executionThread2= new ExecutionThread(3,semaphore);
        ExecutionThread executionThread3= new ExecutionThread(2,semaphore);

        executionThread1.start();
        executionThread2.start();
        executionThread3.start();

    }
}

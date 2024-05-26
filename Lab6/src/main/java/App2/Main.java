package App2;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock reentrantLock1= new ReentrantLock();
        ReentrantLock reentrantLock2= new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new ExecThread(reentrantLock1, null, 1, 3, 5, 6, countDownLatch).start();
        new ExecThread(reentrantLock1, reentrantLock2, 2 , 4, 2, 4, countDownLatch).start();
        new ExecThread(null, reentrantLock2, 4, 6, 2, 3, countDownLatch).start();

    }
}

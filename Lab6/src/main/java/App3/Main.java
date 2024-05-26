package App3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);

        Integer lock1 = new Integer(1);
        Integer lock2 = new Integer(1);

        new NotifThread(latch, lock1, lock2, 5, 2, 4).start();
        new ExecThread(latch, lock1, 3, 2, 3).start();
        new ExecThread(latch, lock2, 4, 4, 6).start();


    }
}
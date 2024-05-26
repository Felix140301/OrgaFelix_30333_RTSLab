package App3;

import java.util.concurrent.CountDownLatch;

public class NotifThread extends Thread {

    CountDownLatch latch;
    int sleepTime, activityMax, activityMin;
    Integer lock1;
    Integer lock2;

    public NotifThread(CountDownLatch latch, Integer lock1, Integer lock2, int sleepTime, int activityMax, int activityMin) {
        this.latch = latch;
        this.sleepTime = sleepTime;
        this.activityMax = activityMax;
        this.activityMin = activityMin;
        this.lock1 = lock1;
        this.lock2 = lock2;

    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep((long) sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (lock1) {
            lock1.notify();
        }
        synchronized (lock2) {
            lock2.notify();
        }
        System.out.println(this.getName() + " - STATE 3");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
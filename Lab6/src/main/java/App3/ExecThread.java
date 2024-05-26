package App3;

import java.util.concurrent.CountDownLatch;

public class ExecThread extends Thread {
    CountDownLatch latch;
    int SleepTime, activityMax, activityMin;
    final Integer lock;

    public ExecThread(CountDownLatch latch, Integer lock, int sleepTime, int activityMax, int activityMin) {
        this.latch = latch;
        this.SleepTime = sleepTime;
        this.activityMax = activityMax;
        this.activityMin = activityMin;
        this.lock = lock;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(SleepTime * 1000);
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");
        latch.countDown();

        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
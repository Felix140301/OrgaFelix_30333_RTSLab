package App4;

public class NotifierThread extends Thread {

    Monitor monitor1;
    Monitor monitor2;

    NotifierThread(Monitor monitor1, Monitor monitor2) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
    }

    public void action(int activity_max, int activity_min) {

        synchronized (this) {
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
    }

    public void sleep(int sleep_max, int sleep_min) {

        synchronized (this) {
            try {
                Thread.sleep(Math.round(Math.random() * sleep_min) * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " is in State 1");
        this.sleep(20, 3);
        this.action(3, 7);
        System.out.println(this.getName() + " is in State 2");
        synchronized (monitor1) {
            monitor1.notify();
            System.out.println(this.getName() + " notified monitor 1");
        }
        synchronized (monitor2) {
            monitor2.notify();
            System.out.println(this.getName() + " notified monitor 2");
        }
        System.out.println(this.getName() + " is in State 3");
    }

}
